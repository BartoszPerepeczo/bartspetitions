package com.example.bartspetitions.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PetitionRepository extends CrudRepository<com.example.bartspetitions.model.Petition, Long> {

    List<com.example.bartspetitions.model.Petition> findByPetitionTitleContaining(String petitionTitle);

    com.example.bartspetitions.model.Petition findById(long id);
}
