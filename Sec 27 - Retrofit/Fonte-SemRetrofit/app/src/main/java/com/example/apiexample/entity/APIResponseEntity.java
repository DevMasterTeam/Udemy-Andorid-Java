package com.example.apiexample.entity;


public class APIResponseEntity {

    private String json;
    private Integer statusCode;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Construtor
     */
    public APIResponseEntity(String json, Integer status) {
        this.json = json;
        this.statusCode = status;
    }
}
