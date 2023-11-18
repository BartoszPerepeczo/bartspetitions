package com.example.bartspetitions.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<com.example.bartspetitions.model.Person, Long> {
    List<com.example.bartspetitions.model.Person> findByIdIn(List<Long> ids);
}