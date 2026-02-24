package com.code4future.springbootthymeleafdemo.dto;

public class LoginForm {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "email='" + email + '\'' +
                '}';
    }
}
