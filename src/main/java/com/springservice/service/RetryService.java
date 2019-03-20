package com.springservice.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public interface RetryService {

    @Retryable(maxAttempts = 10, backoff = @Backoff(delay = 100, maxDelay = 500))
    String retryService();

    @Recover
    public String getBackendResponseFallback(Throwable e);


}
