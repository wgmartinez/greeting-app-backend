package com.equifax.model;

public class GreetingModel {
    private String firstName;
    private String country;
    private String message;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{ \'firstName\': \'" + firstName + "\'" +
            ", \'country\': \'" + country + "\'" +
            ", \'message\': \'" + message + "\'" +
            '}';
    }
}
