package com.example.bartspetitions;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PetitionRepository extends CrudRepository<Petition, Long> {

    List<Petition> findByPetitionTitleContaining(String petitionTitle);

    Petition findById(long id);
}
