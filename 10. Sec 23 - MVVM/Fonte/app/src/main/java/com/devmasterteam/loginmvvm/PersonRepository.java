package com.devmasterteam.loginmvvm;

public class PersonRepository {
    public boolean login(String name) {
        return !name.equals("");
    }
}
