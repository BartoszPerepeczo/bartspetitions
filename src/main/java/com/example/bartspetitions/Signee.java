package com.example.bartspetitions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Signee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String signeeName;
    private String signeeEmail;

    protected Signee() {}

    public Signee(String signeeName, String signeeEmail) {
        this.signeeName = signeeName;
        this.signeeEmail = signeeEmail;
    }

    @Override
    public String toString() {
        return String.format(
                "User[user_Id=%d, user_Name='%s', user_Email='%s']",
                id, signeeName, signeeEmail);
    }

    public Long getId() {
        return id;
    }

    public String getSigneeName() {
        return signeeName;
    }

    public String getSigneeEmail() {
        return signeeEmail;
    }
}
