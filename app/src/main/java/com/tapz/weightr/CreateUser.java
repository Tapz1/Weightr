package com.tapz.weightr;

public class CreateUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public CreateUser(String firstName, String lastName, String email, String password) {
        if(firstName == null || firstName.equals("")){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
