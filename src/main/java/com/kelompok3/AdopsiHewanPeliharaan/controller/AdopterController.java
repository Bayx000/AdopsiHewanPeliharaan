package com.kelompok3.AdopsiHewanPeliharaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.kelompok3.AdopsiHewanPeliharaan.dto.AdopterDto;
import com.kelompok3.AdopsiHewanPeliharaan.service.AdopterService;

@Controller
@RequestMapping("/")
public class AdopterController {
    @Autowired
    private AdopterService adopterService;

    @GetMapping
    public String getAllAdopters(Model model) {
        List<AdopterDto> adopters = adopterService.semua();
        model.addAttribute("adopters", adopters);
        return "adopters";
    }

    @GetMapping("/adopters/save")
    public String viewSaveAdopter() {
        return "create_adopter";
    }

    @PostMapping("/adopters/save")
    public String saveAdopter(@Validated @ModelAttribute AdopterDto adopter, BindingResult result) {
        if (result.hasErrors()) {
            return "create_adopter";
        }
        adopterService.simpan(adopter);
        return "redirect:/";
    }

    @GetMapping("/adopters/delete/{id}")
    public String removeAdopter(@PathVariable("id") Integer id) {
        adopterService.hapus(id);
        return "redirect:/";
    }

}
