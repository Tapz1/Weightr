package com.tapz.weightr;

public class UserModel {
    // this class stores the current user info in a session
    private String firstName;
    private String lastName;
    private String email;

    public UserModel(String firstName, String lastName, String email) {
        /* input validation that also looks for SQL Injection by looking for an equal sign */
        if(firstName.length() > 20 || firstName.contains("=")){
            throw new IllegalArgumentException("Invalid First Name!");
        }
        if(lastName.length() > 20 || lastName.contains("=")){
            throw new IllegalArgumentException("Invalid Last Name!");
        }
        if(email.length() > 50 || email.contains("=")){
            throw new IllegalArgumentException("Invalid email!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
