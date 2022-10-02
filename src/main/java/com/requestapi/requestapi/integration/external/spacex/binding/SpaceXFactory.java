package com.requestapi.requestapi.integration.external.spacex.binding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpaceXFactory {

    @Value("${spaceX.api-url}")
    private String apiURL;


    private SpaceXBinding currentBinding;

    @PostConstruct
    private void initApiBinding() {
        currentBinding = new SpaceXBindingConcrete(
                apiURL
        );
        currentBinding.init();
    }

    @PreDestroy
    public void shutdown() {

        currentBinding.getExecutorService().shutdown();
    }

    public SpaceXBinding getAPIBinding() {
        return currentBinding;
    }


}