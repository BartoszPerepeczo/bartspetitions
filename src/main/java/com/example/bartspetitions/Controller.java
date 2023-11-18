package com.example.bartspetitions;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final PetitionRepository pRepo;
    //private SigneeRepository sRepo;
    //private PetitionSigneeRepository psRepo;

    public Controller(PetitionRepository pRepo) {
        this.pRepo = pRepo;
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
        List<Petition> petitions = new ArrayList<>();
        pRepo.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionList";
    }

    @GetMapping("/petitionList")
    public String petitionList(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Petition> petitions = new ArrayList<>();
        pRepo.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionList";
    }

    @GetMapping("/petitionSearch")
    public String petitionSearch(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Petition> petitions = new ArrayList<>();
        pRepo.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionList";
    }


    @GetMapping("/petitionSign")
    public String petitionSign(
            @RequestParam(value = "id", required = true) String message,
            Model model
    ) {
        List<Petition> petitions = new ArrayList<>();
        pRepo.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        //model.addAttribute("message", message);
        return "petitionSign";
    }
}