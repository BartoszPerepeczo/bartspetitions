package com.example.bartspetitions.repository;

import com.example.bartspetitions.model.PetitionPerson;
import com.example.bartspetitions.model.Person;
import jakarta.persistence.Tuple;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetitionPersonRepository  extends CrudRepository<PetitionPerson, Long> {
    List<PetitionPerson> findByPetitionIdEquals(long petitionId);
    PetitionPerson findByPetitionIdAndPersonId(long petitionId, long personId);
}
