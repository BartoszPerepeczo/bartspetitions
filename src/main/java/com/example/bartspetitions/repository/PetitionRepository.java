package com.example.bartspetitions.repository;

import com.example.bartspetitions.model.Petition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetitionRepository extends CrudRepository<Petition, Long> {

    List<Petition> findByPetitionTitleContaining(String petitionTitle);
    Petition findById(long id);

}
