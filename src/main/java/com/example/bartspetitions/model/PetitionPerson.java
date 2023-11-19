package com.example.bartspetitions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PetitionPerson {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long petitionId;
    private Long personId;

    protected PetitionPerson() {}

    public PetitionPerson(Long petitionId, Long personId) {
        this.petitionId = petitionId;
        this.personId = personId;
    }

    @Override
    public String toString() {
        return String.format(
                "PetitionPerson[Id=%d, petitionId=%d, userId=%d]",
                id, petitionId, personId);
    }
    public Long getPetitionId() {
        return petitionId;
    }

    public void setPetitionId(Long petitionId) {
        this.petitionId = petitionId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getId() {
        return id;
    }
}