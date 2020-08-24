package com.example.tasks.service.listener;

/**
 * A interface permite que sejam criadas classes anônimas capazes de responderem com qualquer
 * tipo de dado que seja fornecido em T.
 * Esse tipo de funcionalidade evita a criação de várias classes APIListener
 * APIListenerHeader, APIListenerTask, APIListenerPerson, etc.
 */
public interface APIListener<T> {

    // Ao termos sucesso na requisição, qualquer parâmetro é aceito desde que declarado dentro dos <>
    void onSuccess(T result);

    // Qual o motivo da falha?
    void onFailure(String message);
}