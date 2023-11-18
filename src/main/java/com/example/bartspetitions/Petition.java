package com.example.bartspetitions;

import jakarta.persistence.*;

@Entity
public class Petition {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long ownerId;
    private String petitionTitle;
    @Lob
    private String petitionSummary;
    @Lob
    private String petitionText;

    protected Petition() {}

    public Petition(Long ownerId, String petitionTitle,String petitionSummary, String petitionText) {
        this.ownerId = ownerId;
        this.petitionTitle = petitionTitle;
        this.petitionSummary = petitionSummary;
        this.petitionText = petitionText;
    }

    @Override
    public String toString() {
        return String.format(
                "Petition[id=%d, ownerId=%d, petitionTitle='%s', petitionSummary='%s', petitionText='%s']",
                id, ownerId, petitionTitle, petitionSummary,petitionText);
    }

    public Long getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getPetitionTitle() {
        return petitionTitle;
    }

    public String getPetitionSummary() {
        return petitionSummary;
    }

    public String getPetitionText() {
        return petitionText;
    }
}
