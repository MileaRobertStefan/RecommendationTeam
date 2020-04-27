package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

@Embeddable
@Document(collection = "Users")
public class Contact {

    private String phone;
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
