package com.example.bartspetitions;


import com.example.bartspetitions.model.*;
import com.example.bartspetitions.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            Model model
    ) {
        return "petitionAdd";
    }

    @PostMapping("/petitionAdd")
    public ModelAndView petitionAdd(
            @RequestParam(value = "petitionTitle", required = true) String petitionTitle,
            @RequestParam(value = "petitionSummary", required = true) String petitionSummary,
            @RequestParam(value = "petitionText", required = true) String petitionText,
            @RequestParam(value = "personName", required = true) String personName,
            @RequestParam(value = "personEmail", required = true) String personEmail,
            Model model, RedirectAttributes attributes,
            HttpServletRequest request ) {

        Person person = personRepository.findByPersonNameAndPersonEmail(personName,personEmail);
        if (person==null) {
            personRepository.save(new Person(personName,personEmail));
            person = personRepository.findByPersonNameAndPersonEmail(personName,personEmail);
        }

        Petition petition = new Petition(person.getId(),petitionTitle,petitionSummary,petitionText);
        petitionRepository.save(petition);
        petitionPersonRepository.save(new PetitionPerson(petition.getId(), person.getId()));

        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        attributes.addAttribute("id", String.valueOf(petition.getId()));
        return new ModelAndView("redirect:/petitionSign");
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

    @GetMapping("/petitionSign")
    public String petitionSign(
            @RequestParam(value = "id", required = true) String id,
            Model model
    ) {
        Petition petition = this.petitionRepository.findById(Long.parseLong(id));

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
    public ModelAndView petitionSign(
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
        model.addAttribute("personName", personName);
        model.addAttribute("personEmail", personEmail);

        return new ModelAndView("petitionSign");
    }

}