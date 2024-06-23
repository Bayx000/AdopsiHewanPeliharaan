package com.kelompok3.AdopsiHewanPeliharaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Map;
import com.kelompok3.AdopsiHewanPeliharaan.dto.AnimalDto;
import com.kelompok3.AdopsiHewanPeliharaan.service.AdopterService;
import com.kelompok3.AdopsiHewanPeliharaan.service.AnimalService;

import jakarta.validation.Valid;

@Controller
public class AnimalController {
    @Autowired
    AdopterService adopterService;

    @Autowired
    AnimalService animalService;

    @GetMapping("/adopter/{id}/animal")
    public String animalView(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("adopter", adopterService.satu(id));
        model.addAttribute("allAnimal", animalService.semua(id));
        return "animal";
    }

    @GetMapping("/adopter/{id}/animal/simpan")
    public String simpanAnimalView(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("adopter", adopterService.satu(id));
        return "tambah-animal";
    }

    @GetMapping("/adopter/{id}/animal/{animal_id}")
    public String ubahAnimalView(@PathVariable Map<String, String> pvMap, Model model) {
        model.addAttribute("adopter", adopterService.satu(Integer.valueOf(pvMap.get("id"))));
        model.addAttribute("animal", adopterService.satu(Integer.valueOf(pvMap.get("animal_id"))));
        return "ubah-animal";
    }

    @PostMapping("/adopter/{id}/animal/simpan")
    public String simpan(@PathVariable("id") Integer id, @Valid AnimalDto animalDto, BindingResult result) {
        if (result.hasErrors()) {
            return "tambah-animal";
        }
        animalService.simpan(id, animalDto);
        return "redirect:/adopter/{id}/animal";
    }

    @PostMapping("/adopter/{id}/animal/ubah/{animal_id}")
    public String ubah(@PathVariable Map<String, String> pvMap, @Valid AnimalDto animalDto, BindingResult result) {
        if (result.hasErrors()) {
            return "ubah-animal";
        }
        animalService.ubah(Integer.valueOf(pvMap.get("animal_id")), animalDto);
        return "redirect:/adopter/{id}/animal";
    }

    @GetMapping("/adopter/{id}/animal/hapus/{animal_id}")
    public String hapus(@PathVariable Map<String, String> pvMap) {
        Integer animal_id = Integer.valueOf(pvMap.get("animal_id"));
        animalService.hapus(animal_id);
        return "redirect:/adpoter/{id}/animal";
    }
}