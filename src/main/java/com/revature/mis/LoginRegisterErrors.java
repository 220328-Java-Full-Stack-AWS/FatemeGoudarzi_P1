package com.revature.mis;

public class LoginRegisterErrors {
    private String response;
    public LoginRegisterErrors(String err) {
        this.response=err;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
