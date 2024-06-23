package com.kelompok3.AdopsiHewanPeliharaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelompok3.AdopsiHewanPeliharaan.model.Adopter;

@Repository
public interface AdopterRepo extends JpaRepository<Adopter, Integer> {
}