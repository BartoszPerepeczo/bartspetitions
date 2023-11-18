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
                "PetitionPerson[Id=%d, petition_Id=%d, user_Id='%d']",
                id, petitionId, personId);
    }
    public Long getPetition_Id() {
        return petitionId;
    }

    public void setPetition_Id(Long petition_Id) {
        this.petitionId = petition_Id;
    }

    public Long getUser_Id() {
        return personId;
    }

    public void setUser_Id(Long user_Id) {
        this.personId = user_Id;
    }

    public Long getId() {
        return id;
    }
}