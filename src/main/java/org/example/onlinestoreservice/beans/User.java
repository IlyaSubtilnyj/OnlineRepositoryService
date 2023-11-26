package org.example.onlinestoreservice.beans;

import org.example.onlinestoreservice.beans.AbstractModel;

public class User extends AbstractModel {
    private String name;
    private boolean isSignIn;

    public boolean isSignIn() {
        return isSignIn;
    }

    public void setSignIn(boolean signIn) {
        isSignIn = signIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

