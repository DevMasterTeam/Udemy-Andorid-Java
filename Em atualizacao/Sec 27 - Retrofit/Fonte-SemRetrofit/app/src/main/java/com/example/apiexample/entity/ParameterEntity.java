package com.example.apiexample.entity;

import java.util.AbstractMap;
import java.util.HashMap;

/**
 * Classe responsável por todos os parâmetros usados para fazer a chama a API
 */
public class ParameterEntity {

    // Método HTTP
    private String method;

    // URL com recurso que será chamado
    private String url;

    // Parametros
    private AbstractMap<String, String> parameters;

    // Parâmetros header
    private AbstractMap<String, String> headerParameters;

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public AbstractMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(AbstractMap<String, String> parameters) {
        this.parameters = parameters;
    }

    public AbstractMap<String, String> getHeaderParameters() {
        return headerParameters;
    }

    public void setHeaderParameters(AbstractMap<String, String> headerParameters) {
        this.headerParameters = headerParameters;
    }

    // Construtor
    public ParameterEntity(String method, String url, HashMap params, HashMap headerParams) {
        this.method = method;
        this.url = url;
        this.parameters = params;
        this.headerParameters = headerParams;
    }
}