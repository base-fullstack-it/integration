package com.requestapi.requestapi.integration.request;

import com.requestapi.requestapi.integration.thread.CustomAPIExecutor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;

import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public abstract class RequestAPIBindingBase implements RequestApiBindingInterface {
    protected HttpHeaders httpHeaders;
    protected CustomAPIExecutor customAPIExecutor;

    @Override
    public void init() {
        this.httpHeaders = setHttpHeaders();
    }

    @Override
    public <T> ResponseWrapper<T> makeRequest(URI uri, HttpMethod httpMethod, Class<T> returnClazz) {
        return makeRequest(uri, httpMethod, returnClazz, null);
    }
    @Override
    public <T> ResponseWrapper<T> makeRequest(URI uri, HttpMethod httpMethod, Class<T> returnClazz, @Nullable Object request) {
        HttpEntity httpEntity = new HttpEntity(request, httpHeaders);
            return RequestApi.makeRequest(uri, httpMethod, httpEntity, returnClazz);
    }

    @Override
    public void makeAsyncRequest(URI uri, HttpMethod httpMethod, @Nullable Object request) {
        HttpEntity httpEntity = new HttpEntity(request, httpHeaders);
        CompletableFuture.runAsync(() -> RequestApi.makeRequest(uri, httpMethod, httpEntity, String.class), getExecutorService());
    }

    @Override
    public ExecutorService getExecutorService() {
        return this.customAPIExecutor.getExecutorService();
    };

    public abstract String getApiUrl();

    public abstract CustomAPIExecutor createAPIExecutorService();

    protected HttpHeaders setHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        return httpHeaders;
    }
}
