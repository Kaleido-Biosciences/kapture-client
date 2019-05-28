# Kapture Client
This module provides a client for the webservices of the Kapture Application.

# Configuration
The module provides a number of beans that are configured by the `KaptureClientConfiguration` class.
This class, in turn, uses the `KaptureClientProperties` class to pickup external configuration using
standard Spring approaches. The class is configured to detect properties prefixed with `kapture.client`.
Default values are set which can be expected to work with a standard `dev` profile Kapture client running
on `localhost` connecting as the `admin` user.

## Configure for a remote or production application
Generally you will only need to change two properties (through environment variable or config files). These are:
`kapture.client.base` which defaults to `http://localhost:8080/api/`. To connect to the production Kapture system you
should set this to `https://kapture.apps.kaleidobio.com/api/`. You will also need to provide a correct value for
`kapture.client.user` (default is `admin`) and `kapture.client.password` which should be the password for the user.

# Using the module in another application or module
The Kapture client can be used in another Spring application (or module) if it is added as a dependency and the appropriate
package scans or imports take place.
## Dependencies
In the `pom.xml` include this dependency (adjusting the version as needed):
```xml
        <dependency>
            <groupId>com.kaleido</groupId>
            <artifactId>kapture-client</artifactId>
            <version>1.1.3-RELEASE</version>
        </dependency>
```
### Injecting Beans
The simplest way to inject the beans of the module is to use the Spring `@Import(com.kaleido.kaptureclient.KaptureClientConfiguration.class)` 
annotation to bring in the `KaptureClientConfiguration` which provides all of the required `@Beans` and configuration needed to use the
module. This will allow `@Beans` from the module to be `@Autoinject`ed or using Springboot they can be automatically
injected via the constructor.

## Example application
Providing the module dependency is declared in the POM the following shows a simple Springboot application which uses
the `KaptureClient<Batch>` class to obtain a list of batches. 

```java
@SpringBootApplication
@Import(com.kaleido.kaptureclient.KaptureClientConfiguration.class)
public class KclientDemoApplication {

    Logger log = LoggerFactory.getLogger(KclientDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KclientDemoApplication.class, args);
    }

    @Component
    class Runner implements CommandLineRunner{

        KaptureClient<Batch> batchClient;

        Runner(KaptureClient<Batch> batchClient){
            this.batchClient = batchClient;
        }


        @Override
        public void run(String... args) throws Exception {
            final ResponseEntity<List<Batch>> batches = batchClient.findAll();
            log.info("Here are the batches: {}", batches);
        }
    }
}
```

# Authentication
The Kapture app and it's REST services are protected with username and password authentication and the identity of
the client must be provided with each service call using a JWT bearer token in the header. For convenience, the module
provides a `KaptureJWTRequestInterceptor` which implements `ClientHttpRequestInterceptor`. This interceptor will inspect
calls and if those calls are to `kapture.client.base` it will inject the appropriate header. If no token is available
the interceptor will use the properties `kapture.client.user` and `kapture.client.password` to authenticate to the `/authenticate`
enpoint of `kapture.client.base` to obtain a JWT token that is then used for subsequent calls. 
As long as these properties are correctly set (or the defaults are correct) no further action should be required by
the application using this module.

# Domain objects
The `com.kaleido.kaptureclient.domain` package holds a number of Java beans that represent the entity objects of Kapture.
These are used by Jackson to marshal the JSON returned by Kapture. If the Kapture domain changes then matching changes
will need to be made in this package.

## New domain objects
If the Kapture application is updated to provide new Entities then the following will be required:

1. A new bean in `com.kaleido.kaptureclient.domain` to represent the object
1. A new field (with public getters and setters) in `KaptureClientProperties` for the new endpoint for the bean, e.g. `private String newEntityEndpoint = "new-entities";`
1. Declare a `@Bean` in `KaptureClientConfiguration` for the new entity type. e.g. 
```java
    @Bean
    KaptureClient<NewEntity> newEntityClient(RestTemplate restTemplate){
        return new KaptureClient<>(kaptureClientProperties.getBase()+kaptureClientProperties.getNewEntityEndpoint(),
                restTemplate, NewEntity.class);
    }
```
