package com.example.convidados.model;

public class GuestModel {

    private int id;
    private String name;
    private int confirmation;

    public GuestModel(int id, String name, int confirmation) {
        this.id = id;
        this.name = name;
        this.confirmation = confirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }
}
