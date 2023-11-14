package com.example.bartspetitions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Petition_Signee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long petitionId;
    private Long signeeId;

    protected Petition_Signee() {}

    public Petition_Signee(Long petitionId, Long signeeId) {
        this.petitionId = petitionId;
        this.signeeId = signeeId;
    }

    @Override
    public String toString() {
        return String.format(
                "Petition_User[Id=%d, petition_Id=%d, user_Id='%d']",
                id, petitionId, signeeId);
    }
    public Long getPetition_Id() {
        return petitionId;
    }

    public void setPetition_Id(Long petition_Id) {
        this.petitionId = petition_Id;
    }

    public Long getUser_Id() {
        return signeeId;
    }

    public void setUser_Id(Long user_Id) {
        this.signeeId = user_Id;
    }

    public Long getId() {
        return id;
    }

}