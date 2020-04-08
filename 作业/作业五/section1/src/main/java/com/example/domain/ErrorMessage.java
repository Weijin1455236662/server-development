package com.example.domain;

public class ErrorMessage {
    private String userNameError;
    private String passwordError;

    public ErrorMessage(){

    }

    public ErrorMessage(String userNameError, String passwordError){
        this.userNameError=userNameError;
        this.passwordError=passwordError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}
