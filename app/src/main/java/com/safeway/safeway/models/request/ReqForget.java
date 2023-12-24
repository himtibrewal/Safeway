package com.safeway.safeway.models.request;

public class ReqForget {
    private String email;

    public ReqForget(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
