package com.kelompok3.AdopsiHewanPeliharaan.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelompok3.AdopsiHewanPeliharaan.dto.AnimalDto;
import com.kelompok3.AdopsiHewanPeliharaan.dto.Mapper;
import com.kelompok3.AdopsiHewanPeliharaan.model.Adopter;
import com.kelompok3.AdopsiHewanPeliharaan.model.Animal;
import com.kelompok3.AdopsiHewanPeliharaan.repository.AdopterRepo;
import com.kelompok3.AdopsiHewanPeliharaan.repository.AnimalRepo;

@Service
public class AnimalService {
    @Autowired
    AnimalRepo animalRepo;

    @Autowired
    AdopterRepo adopterRepo;

    public AnimalDto simpan(Integer id, AnimalDto animalDto) {
        Optional<Adopter> adopter = adopterRepo.findById(id);
        Animal animal = Mapper.mapAnimal(adopter.get(), animalDto);
        return Mapper.mapAnimalDto(animalRepo.save(animal));
    }

    public List<AnimalDto> semua(Integer id) {
        Optional<Adopter> adopter = adopterRepo.findById(id);
        List<Animal> animalByAdopder = animalRepo.findByAdopter(adopter.get());
        return animalByAdopder.stream().map(Mapper::mapAnimalDto).collect(Collectors.toList());
    }

    public AnimalDto satu(Integer id) {
        Optional<Animal> satu = animalRepo.findById(id);
        return Mapper.mapAnimalDto(satu.get());
    }

    public AnimalDto ubah(Integer animal_id, AnimalDto animalDto) {
        Optional<Animal> animal = animalRepo.findById(animal_id);
        Animal _animal = animal.get();
        _animal.setNama_hewan(animalDto.getNama_hewan());
        _animal.setType_hewan(animalDto.getType_hewan());
        _animal.setAvailable(animalDto.getAvailable());
        return Mapper.mapAnimalDto(animalRepo.save(_animal));
    }

    public void hapus(Integer id) {
        animalRepo.deleteById(id);
    }
}
