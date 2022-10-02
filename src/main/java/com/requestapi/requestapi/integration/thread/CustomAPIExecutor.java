package com.requestapi.requestapi.integration.thread;

import java.util.concurrent.ExecutorService;

public interface CustomAPIExecutor {
    void init(ExecutorService executorService);

    ExecutorService getExecutorService();
}
