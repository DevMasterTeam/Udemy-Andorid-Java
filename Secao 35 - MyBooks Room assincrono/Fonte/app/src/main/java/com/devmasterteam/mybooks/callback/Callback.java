package com.devmasterteam.mybooks.callback;

// Interface para callback assíncrono
public interface Callback<T> {
    void onSuccess(T result);
}