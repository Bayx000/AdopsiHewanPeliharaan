package com.kelompok3.AdopsiHewanPeliharaan.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelompok3.AdopsiHewanPeliharaan.model.Adopter;
import com.kelompok3.AdopsiHewanPeliharaan.model.Animal;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Integer> {
    List<Animal> findByAdopter(Adopter adopter);
}