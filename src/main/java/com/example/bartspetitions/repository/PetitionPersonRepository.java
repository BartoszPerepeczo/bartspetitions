package com.example.bartspetitions.repository;

import com.example.bartspetitions.model.PetitionPerson;
import com.example.bartspetitions.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetitionPersonRepository  extends CrudRepository<PetitionPerson, Long> {
    List<Person> findByPetitionIdEquals(long petitionId);
    PetitionPerson findByPersonIdAndPetitionId(long personId, long petitionId);
}
