package com.kaleido.kaptureclient.client;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * The class that is used to interact with the Kapture service. {@code @Bean}s of this class genericized on a
 * (@code domain} package class are made available for injection by class scanning {@code KaptureClientConfiguration}
 *
 * @param <E> The type of {@code domain} package object of the client
 */
public class KaptureClient<E> {

    private Logger log = LoggerFactory.getLogger(KaptureClient.class);

    @Autowired
    ApplicationContext context;

    private final RetryTemplate retryTemplate;

    private final String endpoint;
    private final String searchEndpoint;
    private final RestTemplate restTemplate;
    private final Class<E> entityClass;

    private static final String PAGE = "page";
    private static final String SIZE = "size";
    public static final String QUERY = "query";
    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = Integer.MAX_VALUE;
    private final List<String> fieldsInClass;

    //retains the type of E
    private ParameterizedTypeReference<List<E>> parameterizedTypeReference = new ParameterizedTypeReference<List<E>>() {
        @Override
        public Type getType() {
            return new ParameterizedTypeImpl((ParameterizedType) super.getType(),
                    new Type[]{entityClass});
        }
    };


    /**
     * A client to the Kapture service parameterized on type {@code E}.
     *
     * @param endpoint     the endpoint extension (e.g. {@code /batches}) relevant to type {@code E}
     * @param restTemplate a rest template
     * @param entityClass  the type token of type {@code E}. This is required to get around Java's erasure of generic
     *                     types at runtime.
     */
    public KaptureClient(String endpoint, String searchEndpoint, RestTemplate restTemplate, RetryTemplate retryTemplate, Class<E> entityClass) {
        this.endpoint = endpoint;
        this.searchEndpoint = searchEndpoint;
        this.restTemplate = restTemplate;
        this.entityClass = entityClass;
        this.retryTemplate = retryTemplate;

        this.fieldsInClass = new ArrayList<>();

        ReflectionUtils.doWithFields(entityClass, field -> {

            fieldsInClass.add(field.getName());

            //if the field is a class that has an Id field we need special handling
            if (Arrays.stream(field.getType().getDeclaredFields()).anyMatch(f -> f.getName().equals("id"))) {
                String fieldName = field.getName() + "Id";
                fieldsInClass.add(fieldName);
            }

        });
    }

    public String getEntityClassName() {
        return entityClass.toString();
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    /**
     * Find entities where a named field equals a defined value
     *
     * @param fieldName  the named field
     * @param fieldValue the value that the named field must have
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */
    public ResponseEntity<List<E>> findByFieldEquals(final String fieldName, final String fieldValue) {
        return findByFieldsEqual(Collections.singletonMap(fieldName, fieldValue));
    }

    /**
     * Find entities where a named field equals a defined value
     *
     * @param fieldName  the named field
     * @param fieldValue the named value
     * @param pageNumber the page number to start from (pages numbered from 0)
     * @param pageSize   the maximum number of entities in a page
     * @return the {@code List} of entities that match the search criteria up to {@code pageSize}
     */
    public ResponseEntity<List<E>> findByFieldEquals(final String fieldName, final String fieldValue, int pageNumber, int pageSize) {
        return findByFieldsEqual(Collections.singletonMap(fieldName, fieldValue), pageNumber, pageSize);
    }

    /**
     * Find entities where named fields equal their specified values
     *
     * @param fieldValueMap the map of fields to be search and their respective search values
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */
    public ResponseEntity<List<E>> findByFieldsEqual(final Map<String, String> fieldValueMap) {
        return findByFieldsEqual(fieldValueMap, DEFAULT_PAGE, DEFAULT_SIZE);
    }

    /**
     * Find entities where named fields equal their specified values
     *
     * @param fieldValueMap the map of fields to be search and their respective search values
     * @param pageNumber    the page number to start from (pages numbered from 0)
     * @param pageSize      the maximum number of entities in a page
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */
    public ResponseEntity<List<E>> findByFieldsEqual(
            final Map<String, String> fieldValueMap, final int pageNumber, final int pageSize) {
        return retryTemplate.execute(arg0 -> {
            //check that the entityClass has the fields
            checkSearchFields(fieldValueMap.keySet());


            ResponseEntity<List<E>> responseEntity =
                    restTemplate.exchange(findByFieldsEqualUri(fieldValueMap, pageNumber, pageSize),
                            HttpMethod.GET, null, parameterizedTypeReference);

            return responseEntity;
        });
    }

    /**
     * Find entities where a named field compares to a defined value
     *
     * @param fieldName  the named field
     * @param fieldValue the value that the named field must have for comparison
     * @param operator   the operator for which the value is compared
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */
    public ResponseEntity<List<E>> findByFieldWithOperator(final String fieldName, final String fieldValue, final String operator) {
        return findByFieldWithOperator(fieldName, fieldValue, operator, DEFAULT_PAGE, DEFAULT_SIZE);
    }

    /**
     * Find entities where a named field compares to a defined value
     *
     * @param fieldName  the named field
     * @param fieldValue the named value
     * @param operator   the operator for which the value is compared
     * @param pageNumber the page number to start from (pages numbered from 0)
     * @param pageSize   the maximum number of entities in a page
     * @return the {@code List} of entities that match the search criteria up to {@code pageSize}
     */
    public ResponseEntity<List<E>> findByFieldWithOperator(final String fieldName, final String fieldValue, final String operator, int pageNumber, int pageSize) {
        Map<String, String> operatorMap = Stream.of(new String[][]{
                {"operator", operator},
                {"value", fieldValue},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        return findByFieldsWithOperators(Collections.singletonMap(fieldName, operatorMap), pageNumber, pageSize);
    }

    /**
     * Find entities where named fields compares to their specified values
     *
     * @param fieldValOperatorMap the map of fields to be search and their respective search values and operators
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */

    public ResponseEntity<List<E>> findByFieldsWithOperators(final Map<String, Map<String, String>> fieldValOperatorMap) {
        return findByFieldsWithOperators(fieldValOperatorMap, DEFAULT_PAGE, DEFAULT_SIZE);
    }

    /**
     * Find entities where named fields compares to their specified values
     *
     * @param fieldValOperatorMap the map of fields to be search and their respective search values and operators
     * @param pageNumber          the page number to start from (pages numbered from 0)
     * @param pageSize            the maximum number of entities in a page
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */
    public ResponseEntity<List<E>> findByFieldsWithOperators(final Map<String, Map<String, String>> fieldValOperatorMap, int pageNumber, int pageSize) {
        return retryTemplate.execute(arg0 -> {
            checkSearchFields(fieldValOperatorMap.keySet());

            return restTemplate.exchange(findByFieldsWithOperatorsUri(fieldValOperatorMap, pageNumber, pageSize),
                    HttpMethod.GET, null, parameterizedTypeReference);
        });
    }

    private void checkSearchFields(Set<String> strings) {
        //check that the entityClass has the fields
        //partition the keyset into fields present (true) and fields missing (false)
        Map<Boolean, List<String>> partitions =
                strings.stream().collect(partitioningBy(fieldsInClass::contains));

        if (partitions.get(Boolean.FALSE).size() > 0) {
            log.warn("{} does not contain the fields: {}", entityClass,
                    StringUtils.collectionToCommaDelimitedString(partitions.get(Boolean.FALSE)));
        }
    }

    /**
     * Find and entity using it's {@code id}.
     *
     * @param entityId the id of the entity
     * @return A response with the matching entity (if any)
     */
    public ResponseEntity<E> find(final Long entityId) {
        return retryTemplate.execute(arg0 -> restTemplate.getForEntity(endpoint + "/" + entityId, entityClass));
    }

    public ResponseEntity<List<E>> findAll() {
        return findAll(DEFAULT_PAGE, DEFAULT_SIZE);
    }

    public ResponseEntity<List<E>> findAll(int pageNumber, int pageSize) {
        return retryTemplate.execute(arg0 -> restTemplate.exchange(findByFieldsEqualUri(Collections.EMPTY_MAP, pageNumber, pageSize),
                HttpMethod.GET, null, parameterizedTypeReference));
    }

    /**
     * Save an entity. If the entity has an {@code id} an attempt will be made to update it. If it doesn't have an
     * {@code id} a new entity will be created.
     *
     * @param entity the entity to create or update
     * @return A response with a Body equal to the created or updated entity. If created the {@code id} will now be
     * set.
     */
    public ResponseEntity<E> save(@Valid E entity) {
        return retryTemplate.execute(arg0 -> {
            //check if the id has already been set
            try {
                Long id = (Long) new PropertyDescriptor("id", entityClass).getReadMethod().invoke(entity);
                if (id == null) {
                    //no id, POST it
                    return restTemplate.postForEntity(endpoint, entity, entityClass);
                } else {
                    //got an id, PUT it
                    HttpEntity<E> httpEntity = new HttpEntity<>(entity);
                    return restTemplate.exchange(endpoint, HttpMethod.PUT, httpEntity, entityClass);
                }
            } catch (IntrospectionException | ReflectiveOperationException e) {
                log.error("Error accessing ID of entity {}", entity);
                throw new RuntimeException(e);
            }
        });
    }

    private void processEntityCollection(Collection<E> collection, Class itemClazz, Deque<E> stack, boolean update)
            throws IntrospectionException, ReflectiveOperationException {
        for (E o : collection) {
            if (o != null && !BeanUtils.isSimpleValueType(o.getClass())
                    && itemClazz.getPackage().getName().equals(o.getClass().getPackage().getName())) {
                traverse(o, stack, update);
            }
        }
    }

    public void traverse(Object item, Deque<E> stack, boolean update)
            throws IntrospectionException, ReflectiveOperationException {
        Class itemClazz = item.getClass();
        Field[] fields = itemClazz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            // item is a complex object
            for (Field field : fields) {
                // push item to the stack if item has a field called "id" and it is not set or  updateFlag is set
                if (field.getName().equals("id") && (update ||
                        new PropertyDescriptor("id", itemClazz).getReadMethod().invoke(item) == null)) {
                    stack.push((E) (item));
                }
                if (BeanUtils.isSimpleValueType(field.getType())) continue;

                Object fieldObj = PropertyUtils.getProperty(itemClazz.cast(item), field.getName());
                if (fieldObj instanceof Collection) {
                    processEntityCollection((Collection<E>) fieldObj, itemClazz, stack, update);
                } else if (PropertyUtils.getProperty(itemClazz.cast(item), field.getName()) != null
                        && itemClazz.getPackage().getName().equals(field.getType().getPackage().getName())) {
                    // traverse field object if it is not null, not simple Object and is in the same package as item
                    traverse(PropertyUtils.getProperty(itemClazz.cast(item), field.getName()), stack, update);
                }

            }
        }
    }

    /**
     * Persist an entity and all its related entity if there are not already created.
     * Note that the saveAndUpdate function is generic and can be used by any entities
     * If the entity has an {@code id} an attempt will be made to update it. If it doesn't have an
     * {@code id} a new entity will be created.
     *
     * @param entity the entity to create
     * @return A response with a Body equal to the created entity. If created the {@code id} will now be
     * set.
     */
    public ResponseEntity<E> saveAndUpdate(@Valid E entity, boolean update) {
        return retryTemplate.execute(arg0 -> {
            try {
                Deque<E> stack = new ArrayDeque();
                traverse(entity, stack, update);
                return persistEntities(stack);
            } catch (IntrospectionException | ReflectiveOperationException e) {
                log.error("Error accessing ID of entity {}", entity);
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * @param stack contains an entity and its sub entities that need to be created or updated in the database
     * @return the updated entity
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public ResponseEntity<E> persistEntities(Deque<E> stack)
            throws ReflectiveOperationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return retryTemplate.execute(arg0 -> {
            ResponseEntity<E> response = null;
            for (E item : stack) {
                //response = kaptureClientConfiguration.getClient(item.getClass().getName()).save(item);
                response = getClient(item.getClass()).save(item);
                long id = (Long) PropertyUtils.getProperty(item.getClass().cast(response.getBody()), "id");
                PropertyUtils.setProperty(item, "id", id);
            }
            return response;
        });
    }


    /**
     * Save an entity and all its related entity if there are not already created.
     * Note that the cascade save function must be enabled per Entity beforehand
     * If the entity has an {@code id} an attempt will be made to update it. If it doesn't have an
     * {@code id} a new entity will be created.
     *
     * @param entity the entity to create
     * @return A response with a Body equal to the created entity. If created the {@code id} will now be
     * set.
     */
    public ResponseEntity<E> saveWithCascade(@Valid E entity) {
        return retryTemplate.execute(arg0 -> {
            try {
                Long id = (Long) new PropertyDescriptor("id", entityClass).getReadMethod().invoke(entity);
                if (id == null) {
                    //no id, POST it
                    return restTemplate.postForEntity(endpoint + "?cascadeSave=true", entity, entityClass);
                } else {
                    //got an id, PUT it
                    HttpEntity<E> httpEntity = new HttpEntity<>(entity);
                    return restTemplate.exchange(endpoint + "?cascadeSave=true", HttpMethod.PUT, httpEntity, entityClass);
                }
            } catch (IntrospectionException | ReflectiveOperationException e) {
                log.error("Error accessing ID of entity {}", entity);
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Deletes the entity with the matching {@code entityId}.
     *
     * @param entityId the id of the entity to delete
     * @return a response with no body. The status and headers can be inspected to determine the success or otherwise
     * of the deletion.
     */
    public void delete(final Long entityId) {
        retryTemplate.execute(arg0 -> {
            restTemplate.delete(endpoint + "/{id}", entityId);
            return null;
        });

    }


    /**
     * Convenience method to find entities by their {@code name} field. Most (but not all) Kapture entities have a
     * {@code name} field.
     *
     * @param name the value of the {@code name} you want to search for
     * @return All entities of type {@code E} which have that name
     */
    public ResponseEntity<List<E>> findByName(String name) {
        return findByName(name, DEFAULT_PAGE, DEFAULT_SIZE);
    }

    /**
     * Convenience method to find entities by their {@code name} field. Most (but not all) Kapture entities have a
     * {@code name} field.
     *
     * @param name       the value of the {@code name} you want to search for
     * @param pageNumber the page number to start from (pages numbered from 0)
     * @param pageSize   the maximum number of entities in a page
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */
    public ResponseEntity<List<E>> findByName(String name, int pageNumber, int pageSize) {
        return findByFieldEquals("name", name, pageNumber, pageSize);
    }

    /**
     * Convenience method to find an entity by a {@code name} field. Most (but not all) Kapture entities have a
     * {@code name} field.
     *
     * @param name the value of the {@code name} you want to search for
     * @return The first entity found of type {@code E} which has that name
     */
    public Optional<E> findFirstByName(String name) {
        List<E> body = this.findByName(name, 0, 1).getBody();
        return Optional.ofNullable(body == null ? null : body.size() > 0 ? body.get(0) : null);
    }

    /**
     * Convenience method to find entities by their {@code label} field. Some (but not all) Kapture entities have a
     * {@code label} field.
     *
     * @param label the value of the {@code label} you want to search for
     * @return All entities of type {@code E} which have that label
     */
    public ResponseEntity<List<E>> findByLabel(String label) {
        return findByFieldEquals("label", label);
    }

    /**
     * Convenience method to find entities by their {@code labe} field. Some (but not all) Kapture entities have a
     * {@code label} field.
     *
     * @param label      the value of the {@code label} you want to search for
     * @param pageNumber the page number to start from (pages numbered from 0)
     * @param pageSize   the maximum number of entities in a page
     * @return the {@code List} of entities that match the search criteria up to {@code DEFAULT_SIZE}
     */
    public ResponseEntity<List<E>> findByLabel(String label, int pageNumber, int pageSize) {
        return findByFieldEquals("label", label, pageNumber, pageSize);
    }


    /**
     * Convenience method to find an entity by a {@code label} field. Some (but not all) Kapture entities have a
     * {@code label} field.
     *
     * @param label the value of the {@code label} you want to search for
     * @return The first entity found of type {@code E} which has that label
     */
    public Optional<E> findFirstByLabel(String label) {
        List<E> body = findByLabel(label, 0, 1).getBody();
        return Optional.ofNullable(body == null ? null : body.size() > 0 ? body.get(0) : null);
    }

    /**
     * Search the elastic search backed index of Kapture using a query string. The query string will also match any
     * nested objects that are serialized in the JSON that represents the object
     *
     * @param query the query
     * @return the first 20 {@code (DEFAULT_SIZE)} matching objects
     */
    public ResponseEntity<List<E>> search(String query) {
        return search(query, DEFAULT_PAGE, DEFAULT_SIZE);
    }

    /**
     * Search the elastic search backed index of Kapture using a query string. The query string will also match any
     * nested objects that are serialized in the JSON that represents the object
     *
     * @param query      the query string
     * @param pageNumber the page number to start from (pages numbered from 0)
     * @param pageSize   the maximum number of entities in a page
     * @return the list of matching entities
     */
    public ResponseEntity<List<E>> search(String query, int pageNumber, int pageSize) {
        return retryTemplate.execute(arg0 -> {
            URI searchUri = searchUri(query, pageNumber, pageSize);
            return restTemplate.exchange(searchUri, HttpMethod.GET, null, parameterizedTypeReference);
        });

    }

    /**
     * Builds the URI with appropriate query parameters to find entities by field
     *
     * @param fieldName the name of the field to search on
     * @param value     the value of the field to match
     * @return the URI that can be called to execute the search
     */
    protected URI findByFieldEqualsUri(String fieldName, String value) {
        return findByFieldsEqualUri(Collections.singletonMap(fieldName, value), DEFAULT_PAGE, DEFAULT_SIZE);
    }

    /**
     * Builds the URI with appropriate query parameters to find entities by one or more fields
     *
     * @param fieldValMap a map of fields to search and their respective values to match
     * @return the URI that can be called to execute the search
     */
    protected URI findByFieldsEqualUri(Map<String, String> fieldValMap, int pageNumber, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(endpoint);

        fieldValMap.forEach((key, value) -> builder.queryParam(key + ".equals", value));

        //add the page number and page size parameters to the query
        builder.queryParam(PAGE, pageNumber).queryParam(SIZE, pageSize);

        return builder.build().toUri();
    }

    /**
     * Builds the URI with appropriate query parameters to find entities by field
     *
     * @param fieldName the name of the field to search on
     * @param value     the value of the field to match
     * @param operator  the operator to match the value against
     * @return the URI that can be called to execute the search
     */
    protected URI findByFieldWithOperatorUri(String fieldName, String value, String operator) {
        return findByFieldWithOperatorUri(fieldName, value, operator, DEFAULT_PAGE, DEFAULT_SIZE);
    }

    /**
     * Builds the URI with appropriate query parameters to find entities by field
     *
     * @param fieldName the name of the field to search on
     * @param value     the value of the field to match
     * @param operator  the operator to match the value against
     * @return the URI that can be called to execute the search
     */
    protected URI findByFieldWithOperatorUri(String fieldName, String value, String operator, int pageNumber, int pageSize) {
        Map<String, String> operatorMap = Stream.of(new String[][]{
                {"operator", operator},
                {"value", value},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        return findByFieldsWithOperatorsUri(Collections.singletonMap(fieldName, operatorMap), pageNumber, pageSize);
    }

    /**
     * Builds the URI with appropriate query parameters to find entities by one or more fields
     *
     * @param fieldValOperatorMap a map of fields to search and their respective values to check against the mapped operators
     * @return the URI that can be called to execute the search
     */
    protected URI findByFieldsWithOperatorsUri(Map<String, Map<String, String>> fieldValOperatorMap, int pageNumber, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(endpoint);

        fieldValOperatorMap.forEach((key, value) -> builder.queryParam(key + "." + value.get("operator"), value.get("value")));

        //add the page number and page size parameters to the query
        builder.queryParam(PAGE, pageNumber).queryParam(SIZE, pageSize);

        return builder.build().toUri();
    }

    /**
     * Builds the search URI
     *
     * @param query      the query for the search
     * @param pageNumber the page of results to request (number from 0)
     * @param pageSize   the size of the results to request
     * @return the URI representing the request
     */
    protected URI searchUri(String query, int pageNumber, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(searchEndpoint);

        return builder.queryParam(QUERY, query)
                .queryParam(PAGE, pageNumber).queryParam(SIZE, pageSize).build().toUri();
    }

    public KaptureClient getClient(Class entityClass) throws ClassCastException {
        String beanName = StringUtils.uncapitalize(entityClass.getSimpleName()) + "Client";
        return (KaptureClient) context.getBean(beanName);
    }

}
