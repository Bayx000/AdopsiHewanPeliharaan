package com.kelompok3.AdopsiHewanPeliharaan.dto;

import com.kelompok3.AdopsiHewanPeliharaan.model.Adopter;
import com.kelompok3.AdopsiHewanPeliharaan.model.Animal;

public class Mapper {
    
    public static AdopterDto mapAdopterDto(Adopter adopter) {
        AdopterDto adopterDto = new AdopterDto();
        adopterDto.setId(adopter.getId());
        adopterDto.setNama(adopter.getNama());
        adopterDto.setEmail(adopter.getEmail());
        adopterDto.setNomor_telepon(adopter.getNomor_telepon());
        adopterDto.setAddres(adopter.getAddres());

        return adopterDto;
    }

    public static Adopter mapAdopter(AdopterDto adopterDto) {
        Adopter adopter = new Adopter();
        adopter.setNama(adopterDto.getNama());
        adopter.setEmail(adopterDto.getEmail());
        adopter.setNomor_telepon(adopterDto.getNomor_telepon());
        adopter.setAddres(adopterDto.getAddres());

        return adopter;
    }

    public static AnimalDto mapAnimalDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setNama_hewan(animal.getNama_hewan());
        animalDto.setType_hewan(animal.getType_hewan());
        animalDto.setAvailable(animal.getAvailable());

        return animalDto;
    }

    public static Animal mapAnimal(Adopter adopter, AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.setAdopter(adopter);
        animal.setNama_hewan(animalDto.getNama_hewan());
        animal.setType_hewan(animalDto.getType_hewan());
        animal.setAvailable(animalDto.getAvailable());

        return animal;
    }
}
