package com.example.bartspetitions;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String personName;
    private String personEmail;

    protected Person() {}

    public Person(String personName, String personEmail) {
        this.personName = personName;
        this.personEmail = personEmail;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, personName='%s', personEmail='%s']",
                id, personName, personEmail);
    }

    public Long getId() {
        return id;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }
}
