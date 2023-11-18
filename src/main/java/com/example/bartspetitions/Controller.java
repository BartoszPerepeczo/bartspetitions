package com.example.bartspetitions;


import com.example.bartspetitions.repository.PersonRepository;
import com.example.bartspetitions.repository.PetitionPersonRepository;
import com.example.bartspetitions.repository.PetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final PetitionRepository petition;
    private final PersonRepository personRepository;
    private PetitionPersonRepository petitionPersonRepository;

    @Autowired
    public Controller(PetitionRepository petition, PersonRepository personRepository, PetitionPersonRepository petitionPersonRepository) {
        this.petition = petition;
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
        petition.findAll().forEach(petitions::add);
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
                petition.findAll().forEach(petitions::add);
            } else {
                petitions.addAll(petition.findByPetitionTitleContaining(search));
            }
        }
        else {
            petition.findAll().forEach(petitions::add);
        }
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionList";
    }

    @GetMapping("/petitionSearch")
    public String petitionSearch(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<com.example.bartspetitions.model.Petition> petitions = new ArrayList<>();
        petition.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionList";
    }


    @GetMapping("/petitionSign")
    public String petitionSign(
            @RequestParam(value = "id", required = true) String id,
            Model model
    ) {
        com.example.bartspetitions.model.Petition petition = this.petition.findById(Long.parseLong(id));

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
}