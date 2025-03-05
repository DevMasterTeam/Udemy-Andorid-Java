package com.example.programandointerface.business;

public class UserBusiness {

    public boolean checkCredentials(String email, String password) {
        return !"".equals(email) && !"".equals(password);
    }

}
