package com.devmasterteam.tasks.service.listener;

public interface DBListener<T> {
    void onSuccess(T result);
}
