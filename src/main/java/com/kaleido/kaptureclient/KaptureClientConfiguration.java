/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient;

import com.kaleido.kaptureclient.authentication.KaptureJWTRequestInterceptor;
import com.kaleido.kaptureclient.authentication.UserCredentials;
import com.kaleido.kaptureclient.client.KaptureClient;
import com.kaleido.kaptureclient.client.KaptureClientHTTPException;
import com.kaleido.kaptureclient.client.KaptureResponseErrorHandler;
import com.kaleido.kaptureclient.domain.*;
import com.kaleido.kaptureclient.domain.dto.AssayReadoutDTO;
import com.kaleido.kaptureclient.domain.dto.LimsSequencingFileDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides the {@code @Beans} needed for the Kapture client. Applications using this library should include this class
 * in the list of scanned classes or packages. {@code @Beans} in this class are configured through externalized configuration
 * such as an {@code application.properties} file via the {@code KaptureClientProperties} class
 */
@SpringBootApplication
@EnableConfigurationProperties(KaptureClientProperties.class)
public class KaptureClientConfiguration {

    private KaptureClientProperties kaptureClientProperties;


    public KaptureClientConfiguration(KaptureClientProperties kaptureClientProperties) {
        this.kaptureClientProperties = kaptureClientProperties;
    }

    @Bean
    @Primary
    RestTemplate restTemplate(KaptureJWTRequestInterceptor kaptureJWTRequestInterceptor) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(kaptureJWTRequestInterceptor);
        restTemplate.setErrorHandler(new KaptureResponseErrorHandler());
        return restTemplate;
    }

    /**
     * Configuration for Kapture Client Retry template.  When a request returns an exception related to 502 or 503
     * the service can automatically retry up to a predefined amount of times (Default: 3 including original call)
     * after an incremental amount of wait time (Default 5 seconds, doubling each attempt with default max of 15 seconds)
     * The following KaptureClientProperties can be changed to change the behavior of the retryTemplate
     * <p>
     * retryInterval: The initial delay, in milliseconds, before the request is retried (default: 5000L)
     * retryMultiplier: The value that the delay interval will be multiplied by before each attempt (default: 2.0D)
     * For example an initial delay of 5000ms at multiplier 2.0, the second attempt would wait 10000ms
     * and the third attempt would wait 20000ms.
     * maxRetryInterval: The max delay, in milliseconds, that the retry would wait before retrying. (default: 15000L)
     * maxRequestAttempts: The max amount of times a request can be called.  This value is inclusive of the original attempt.
     * Setting this value to 1 would effectively disable retry.
     **/
    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(kaptureClientProperties.getRetryInterval());
        exponentialBackOffPolicy.setMultiplier(kaptureClientProperties.getRetryMultiplier());
        exponentialBackOffPolicy.setMaxInterval(kaptureClientProperties.getMaxRetryInterval());
        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);
        Map<Class<? extends Throwable>, Boolean> includeExceptions = new HashMap<>();
        includeExceptions.put(KaptureClientHTTPException.KaptureClientGatewayTimeoutException.class, true);
        includeExceptions.put(KaptureClientHTTPException.KaptureClientBadGatewayException.class, true);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(kaptureClientProperties.getMaxRequestAttempts(), includeExceptions);
        retryTemplate.setRetryPolicy(retryPolicy);

        return retryTemplate;
    }

    @Bean
    KaptureJWTRequestInterceptor kaptureJWTRequestInterceptor(UserCredentials userCredentials) {
        return new KaptureJWTRequestInterceptor(userCredentials, kaptureClientProperties);
    }

    @Bean
    KaptureClient<AltLabel> altLabelClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAltLabelEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAltLabelEndpoint(),
                restTemplate, retryTemplate, AltLabel.class);
    }

    @Bean
    KaptureClient<Analyte> analyteClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAnalyteEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAnalyteEndpoint(),
                restTemplate, retryTemplate, Analyte.class);
    }

    @Bean
    KaptureClient<AnalyteType> analyteTypeClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAnalyteTypeEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAnalyteTypeEndpoint(),
                restTemplate, retryTemplate, AnalyteType.class);
    }

    @Bean
    KaptureClient<AssayReadout> assayReadoutClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAssayReadoutEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAssayReadoutEndpoint(),
                restTemplate, retryTemplate, AssayReadout.class);
    }

    @Bean
    KaptureClient<AssayReadoutProperty> assayReadoutPropertyClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAssayReadoutPropertyEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAssayReadoutPropertyEndpoint(),
                restTemplate, retryTemplate, AssayReadoutProperty.class);
    }

    @Bean
    KaptureClient<Association> associationClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAssociationEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAssociationEndpoint(),
                restTemplate, retryTemplate, Association.class);
    }

    @Bean
    KaptureClient<Authority> authorityClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAuthorityEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAuthorityEndpoint(),
                restTemplate, retryTemplate, Authority.class);
    }

    @Bean
    KaptureClient<Batch> batchClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getBatchEndpoint(),
                restTemplate, retryTemplate, Batch.class);
    }

    @Bean
    KaptureClient<BatchAlias> batchAliasClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchAliasEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getBatchAliasEndpoint(),
                restTemplate, retryTemplate, BatchAlias.class);
    }

    @Bean
    KaptureClient<BatchComponent> batchComponentClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchComponentEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getBatchComponentEndpoint(),
                restTemplate, retryTemplate, BatchComponent.class);
    }

    @Bean
    KaptureClient<BatchLot> batchLotClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchLotEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getBatchLotEndpoint(),
                restTemplate, retryTemplate, BatchLot.class);
    }

    @Bean
    KaptureClient<BatchLotComposition> batchLotCompositionClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchLotCompositionEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getBatchLotCompositionEndpoint(),
                restTemplate, retryTemplate, BatchLotComposition.class);
    }


    @Bean
    KaptureClient<ChemicalConcept> chemicalConceptClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getChemicalConceptEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getChemicalConceptEndpoint(),
                restTemplate, retryTemplate, ChemicalConcept.class);
    }

    @Bean
    KaptureClient<Community> communityClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getCommunityEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getCommunityEndpoint(),
                restTemplate, retryTemplate, Community.class);
    }
    
    @Bean
    KaptureClient<CommunityComposition> communityCompositionClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getCommunityCompositionEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getCommunityCompositionEndpoint(),
                restTemplate, retryTemplate, CommunityComposition.class);
    }
    
    @Bean
    KaptureClient<Concept> conceptClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getConceptEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getConceptEndpoint(),
                restTemplate, retryTemplate, Concept.class);
    }

    @Bean
    KaptureClient<ConceptScheme> conceptSchemeClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getConceptSchemeEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getConceptSchemeEndpoint(),
                restTemplate, retryTemplate, ConceptScheme.class);
    }

    @Bean
    KaptureClient<Experiment> experimentClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getExperimentEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getExperimentEndpoint(),
                restTemplate, retryTemplate, Experiment.class);
    }

    @Bean
    KaptureClient<FailedMessage> failedMessageClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getFailedMessageEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getFailedMessageEndpoint(),
                restTemplate, retryTemplate, FailedMessage.class);
    }

    @Bean
    KaptureClient<ImportedFile> importedFileClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getImportedFileEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getImportedFileEndpoint(),
                restTemplate, retryTemplate, ImportedFile.class);
    }

    @Bean
    KaptureClient<Media> mediaClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getMediaEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getMediaEndpoint(),
                restTemplate, retryTemplate, Media.class);
    }

    @Bean
    KaptureClient<MediaLot> MediaLotClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getMediaLotEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getMediaLotEndpoint(),
                restTemplate, retryTemplate, MediaLot.class);
    }

    @Bean
    KaptureClient<MediaLotComposition> mediaLotCompositionClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getMediaLotCompositionEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getMediaLotCompositionEndpoint(),
                restTemplate, retryTemplate, MediaLotComposition.class);
    }

    @Bean
    KaptureClient<Monomer> monomerClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getMonomerEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getMonomerEndpoint(),
                restTemplate, retryTemplate, Monomer.class);
    }

    @Bean
    KaptureClient<MonomerComposition> monomerCompositionClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getMonomerCompositionEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getMonomerCompositionEndpoint(),
                restTemplate, retryTemplate, MonomerComposition.class);
    }

    @Bean
    KaptureClient<NmrAssay> nmrAssayClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getNmrAssayEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getNmrAssayEndpoint(),
                restTemplate, retryTemplate, NmrAssay.class);
    }
    
    @Bean
    KaptureClient<NmrImport> nmrImportClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getNmrImportEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getNmrImportEndpoint(),
                restTemplate, retryTemplate, NmrImport.class);
    }   
    
    @Bean
    KaptureClient<NmrProjection> nmrProjectionClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getNmrProjectionEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getNmrProjectionEndpoint(),
                restTemplate, retryTemplate, NmrProjection.class);
    }   
    
    @Bean
    KaptureClient<NmrSpectra> nmrSpectraClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getNmrSpectraEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getNmrSpectraEndpoint(),
                restTemplate, retryTemplate, NmrSpectra.class);
    }

    @Bean
    KaptureClient<NmrPeak> nmrPeakClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getNmrPeakEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getNmrPeakEndpoint(),
                restTemplate, retryTemplate, NmrPeak.class);
    }

    @Bean
    KaptureClient<Note> noteClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getNoteEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getNoteEndpoint(),
                restTemplate, retryTemplate, Note.class);
    }

    @Bean
    KaptureClient<Notebook> notebookClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getNotebookEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getNotebookEndpoint(),
                restTemplate, retryTemplate, Notebook.class);
    }

    @Bean
    KaptureClient<ObservedTaxonomicUnit> observedTaxonomicUnitClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getObservedTaxonomicUnitEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getObservedTaxonomicUnitEndpoint(),
                restTemplate, retryTemplate, ObservedTaxonomicUnit.class);
    }

    @Bean
    KaptureClient<ObservedTaxonomicUnitCount> observedTaxonomicUnitCountClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getObservedTaxonomicUnitCountEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getObservedTaxonomicUnitCountEndpoint(),
                restTemplate, retryTemplate, ObservedTaxonomicUnitCount.class);
    }

    @Bean
    KaptureClient<OtuCountProperty> otuCountPropertyClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getOtuCountPropertyEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getOtuCountPropertyEndpoint(),
                restTemplate, retryTemplate, OtuCountProperty.class);
    }

    @Bean
    KaptureClient<PersistentAuditEvent> persistentAuditEventClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getPersistentAuditEventEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getPersistentAuditEventEndpoint(),
                restTemplate, retryTemplate, PersistentAuditEvent.class);
    }

    @Bean
    KaptureClient<PlateType> plateTypeClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getPlateTypeEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getPlateTypeEndpoint(),
                restTemplate, retryTemplate, PlateType.class);
    }

    @Bean
    KaptureClient<Platemap> platemapClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getPlatemapEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAnalyteTypeEndpoint(),
                restTemplate, retryTemplate, Platemap.class);
    }

    @Bean
    KaptureClient<ProcessedReadout> processedReadoutClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getProcessedReadoutEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getProcessedReadoutEndpoint(),
                restTemplate, retryTemplate, ProcessedReadout.class);
    }

    @Bean
    KaptureClient<Sample> sampleClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getSampleEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAnalyteTypeEndpoint(),
                restTemplate, retryTemplate, Sample.class);
    }
    
    @Bean
    KaptureClient<SampleProperty> samplePropertyClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getSamplePropertyEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getAnalyteTypeEndpoint(),
                restTemplate, retryTemplate, SampleProperty.class);
    }

    @Bean
    KaptureClient<Scientist> scientistClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getScientistEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getScientistEndpoint(),
                restTemplate, retryTemplate, Scientist.class);
    }

    @Bean
    KaptureClient<SequencingRun> sequencingRunClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getSequencingRunEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getSequencingRunEndpoint(),
                restTemplate, retryTemplate, SequencingRun.class);
    }

    @Bean
    KaptureClient<Supplement> supplementClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getSupplementEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getSupplementEndpoint(),
                restTemplate, retryTemplate, Supplement.class);
    }

    @Bean
    KaptureClient<SupplementMetadata> supplementMetadataClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getSupplementMetadataEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getSupplementMetadataEndpoint(),
                restTemplate, retryTemplate, SupplementMetadata.class);
    }
    
    @Bean
    KaptureClient<User> userClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getUserEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getUserEndpoint(),
                restTemplate, retryTemplate, User.class);
    }

    @Bean
    KaptureClient<Well> wellClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getWellEndpoint(),
                kaptureClientProperties.getBase() +
                        kaptureClientProperties.getSearchPathComponent() + "/"
                        + kaptureClientProperties.getWellEndpoint(),
                restTemplate, retryTemplate, Well.class);
    }

    @Bean
    KaptureClient<AssayReadoutDTO> assayReadoutDTOClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getAssayReadoutDTOEndpoint(),
                null,
                restTemplate, retryTemplate, AssayReadoutDTO.class);
    }
    
    @Bean
    KaptureClient<LimsSequencingFileDTO> limsSequencingFileDTOClient(RestTemplate restTemplate, RetryTemplate retryTemplate) {
        return new KaptureClient<>(kaptureClientProperties.getBase() + kaptureClientProperties.getLimsSequencingFileDTOEndpoint(),
                null,
                restTemplate, retryTemplate, LimsSequencingFileDTO.class);
    }

}
