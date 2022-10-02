package com.requestapi.requestapi.integration.external.spacex.binding;

import com.requestapi.requestapi.integration.request.RequestAPIBindingBase;
import com.requestapi.requestapi.integration.thread.CustomAPIExecutor;
import com.requestapi.requestapi.integration.thread.CustomAPIExecutorConcrete;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class SpaceXBindingConcrete extends RequestAPIBindingBase implements SpaceXBinding {
    private final String apiURL;

    public SpaceXBindingConcrete(String apiURL) {
        this.apiURL = apiURL;
    }
    @Override
    public void init() {
        super.init();
        this.customAPIExecutor = createAPIExecutorService();
    }

    @Override
    public String getApiUrl() {
        return UriComponentsBuilder.fromHttpUrl(apiURL).build().toString();
    }

    @Override
    public CustomAPIExecutor createAPIExecutorService() {
        CustomAPIExecutor apiExecutor = new CustomAPIExecutorConcrete("spaceX");
        // change threads here depending on need
        apiExecutor.init(Executors.newSingleThreadExecutor());
        return apiExecutor;
    }

    protected HttpHeaders setHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        return httpHeaders;
    }

}
