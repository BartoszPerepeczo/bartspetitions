package com.example.bartspetitions;

import jakarta.persistence.*;


@Entity
public class Petition {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String petitionTitle;
    @Lob
    private String petitionText;

    protected Petition() {}

    public Petition(String petitionTitle, String petitionText) {
        this.petitionTitle = petitionTitle;
        this.petitionText = petitionText;
    }

    @Override
    public String toString() {
        return String.format(
                "Petition[petition_Id=%d, petition_Title='%s', petition_Text='%s']",
                id, petitionTitle, petitionText);
    }

    public Long getId() {
        return id;
    }

    public String getPetitionTitle() {
        return petitionTitle;
    }

    public String getPetitionText() {
        return petitionText;
    }
}
