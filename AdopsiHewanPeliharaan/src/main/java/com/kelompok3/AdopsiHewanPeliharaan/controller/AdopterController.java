package com.kelompok3.AdopsiHewanPeliharaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.kelompok3.AdopsiHewanPeliharaan.model.Adopter;
import com.kelompok3.AdopsiHewanPeliharaan.repository.AdopterRepo;

@Controller
@RequestMapping("/")
public class AdopterController {
    @Autowired
    private AdopterRepo adopterRepo;

    @GetMapping
    public String getAllAdopters(Model model){
        List<Adopter> adopters = adopterRepo.findAll();
        model.addAttribute("adopters", adopters);
        return "adopters";
    }

    @PostMapping("/adopters")
    public String saveAdopter(@Validated @ModelAttribute Adopter adopter){
        adopterRepo.save(adopter);
        return "redirect:/adopters";
    }

    
}
