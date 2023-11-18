package com.example.bartspetitions;


import com.example.bartspetitions.model.*;
import com.example.bartspetitions.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final PetitionRepository petitionRepository;
    private final PersonRepository personRepository;
    private final PetitionPersonRepository petitionPersonRepository;

    @Autowired
    public Controller(PetitionRepository petitionRepository, PersonRepository personRepository, PetitionPersonRepository petitionPersonRepository) {
        this.petitionRepository = petitionRepository;
        this.personRepository = personRepository;
        this.petitionPersonRepository = petitionPersonRepository;
    }

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/petitionAdd")
    public String petitionAdd(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<com.example.bartspetitions.model.Petition> petitions = new ArrayList<>();
        petitionRepository.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionList";
    }

    @GetMapping("/petitionList")
    public String petitionList(
            @RequestParam(value = "search", required = false) String search,
            Model model
    ) {
        List<com.example.bartspetitions.model.Petition> petitions = new ArrayList<>();
        if (search != null) {
            if (search.isEmpty()) {
                model.addAttribute("search", "");
                petitionRepository.findAll().forEach(petitions::add);
            } else {
                model.addAttribute("search", search);
                petitions.addAll(petitionRepository.findByPetitionTitleContaining(search));
            }
        }
        else {
            model.addAttribute("search", "");
            petitionRepository.findAll().forEach(petitions::add);
        }
        model.addAttribute("petitions", petitions);
        return "petitionList";
    }

    /*@GetMapping("/petitionSearch")
    public String petitionSearch(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<com.example.bartspetitions.model.Petition> petitions = new ArrayList<>();
        petitionRepository.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionList";
    }*/


    @GetMapping("/petitionSign")
    public String petitionSign(
            @RequestParam(value = "id", required = true) String id,
            Model model
    ) {
        com.example.bartspetitions.model.Petition petition = this.petitionRepository.findById(Long.parseLong(id));

        //List<Tuple> personIds = petitionPersonRepository.findByPetitionIdEquals(Long.parseLong(id));
        //List<Person> person = petitionPersonRepository.findByPetitionIdEquals(Long.parseLong(id));
        //String personString = person.toString();
/*
        if(!person.isEmpty()) {
            for (Tuple t : personIds) {
                person += t.toString();

                //Long id = (Long) t.get(0);
                //Long version = (Long) t.get(1);
            }
            //person.addAll(personRepository.findByIdIn(personIds));
        }*/
       // model.addAttribute("person", person);//.toString());
        model.addAttribute("petition", petition);
        return "petitionSign";
    }

    @PostMapping("/petitionSign")
    public String petitionSign(
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "personName", required = false) String personName,
            @RequestParam(value = "personEmail", required = false) String personEmail,
            Model model
    ) {
        Petition petition = this.petitionRepository.findById(Long.parseLong(id));
        Person person = personRepository.findByPersonNameAndPersonEmail(personName,personEmail);
        if (person==null) {
            personRepository.save(new Person(personName,personEmail));
            person = personRepository.findByPersonNameAndPersonEmail(personName,personEmail);
        }
        petitionPersonRepository.save(new PetitionPerson(Long.parseLong(id), person.getId()));

        model.addAttribute("petition", petition);

        //List<Tuple> personIds = petitionPersonRepository.findByPetitionIdEquals(Long.parseLong(id));
        //List<Person> person = petitionPersonRepository.findByPetitionIdEquals(Long.parseLong(id));
        //String personString = person.toString();
/*
        if(!person.isEmpty()) {
            for (Tuple t : personIds) {
                person += t.toString();

                //Long id = (Long) t.get(0);
                //Long version = (Long) t.get(1);
            }
            //person.addAll(personRepository.findByIdIn(personIds));
        }*/
        // model.addAttribute("person", person);//.toString());

        return "petitionSign";
    }

}