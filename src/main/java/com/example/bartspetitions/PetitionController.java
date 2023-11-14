package com.example.bartspetitions;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionController {

    private final PetitionRepository pRepo;
    //private SigneeRepository sRepo;
    //private PetitionSigneeRepository psRepo;

    public PetitionController(PetitionRepository pRepo) {
        this.pRepo = pRepo;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "homePage";
    }

    @GetMapping("/getAllPetitions")
    public String getAllInvoices(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Petition> petitions = new ArrayList<>();
        pRepo.findAll().forEach(petitions::add);
        model.addAttribute("list", petitions);
        model.addAttribute("message", message);
        return "allPetitions";
    }
}
