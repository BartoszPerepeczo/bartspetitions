package com.example.bartspetitions.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.bartspetitions.model.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<com.example.bartspetitions.model.Person, Long> {
    List<Person> findByIdIn(List<Long> ids);
    Person findByPersonNameAndPersonEmail(String personName, String personEmail);
}