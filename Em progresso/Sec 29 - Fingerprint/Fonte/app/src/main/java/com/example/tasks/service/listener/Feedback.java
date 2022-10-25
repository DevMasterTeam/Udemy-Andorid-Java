package com.example.tasks.service.listener;

/**
 * Faz a comunicação entre ViewModel e Activities.
 * Encarregada de passar resposta e mensagem de sucesso ou falha.
 */
public class Feedback {
    private boolean success = true;
    private String message = "";

    /**
     * Construtor vazio - Sucesso, nenhuma mensagem
     */
    public Feedback() {}

    /**
     * Se alguma mensagem é enviada, temos um erro
     */
    public Feedback(String str) {
        this.message = str;
        success = false;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }
}
