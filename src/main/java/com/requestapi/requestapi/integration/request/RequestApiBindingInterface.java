package com.requestapi.requestapi.integration.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;

import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutorService;

public interface RequestApiBindingInterface {
    <T> ResponseWrapper<T> makeRequest(URI uri, HttpMethod httpMethod, Class<T> returnClazz);
    <T> ResponseWrapper<T> makeRequest(URI uri, HttpMethod httpMethod, Class<T> returnClazz,@Nullable Object request);

    void makeAsyncRequest(URI uri, HttpMethod httpMethod, @Nullable Object request);

    String getApiUrl();
    ExecutorService getExecutorService();
    void init();
}
