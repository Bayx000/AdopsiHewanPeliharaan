package com.kelompok3.AdopsiHewanPeliharaan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kelompok3.AdopsiHewanPeliharaan.dto.AdopterDto;
import com.kelompok3.AdopsiHewanPeliharaan.dto.AnimalDto;
import com.kelompok3.AdopsiHewanPeliharaan.service.AdopterService;
import com.kelompok3.AdopsiHewanPeliharaan.service.AnimalService;

@SpringBootApplication
public class AdopsiHewanPeliharaanApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopsiHewanPeliharaanApplication.class, args);
	}

	@Autowired
	AdopterService adopterService;

	@Autowired
	AnimalService animalService;

	@Bean
	public CommandLineRunner run() {
		AdopterDto adopterSeed1 = new AdopterDto();
		adopterSeed1.setNama("Bayu");
		adopterSeed1.setEmail("bayupw86@gmail.com");
		adopterSeed1.setNomor_telepon("089675723233");
		adopterSeed1.setAddres("Jalan Jeruk");

		AdopterDto adopterSeed2 = new AdopterDto();
		adopterSeed2.setNama("Hapis");
		adopterSeed2.setEmail("Hapis02@gmail.com");
		adopterSeed2.setNomor_telepon("089623415222");
		adopterSeed2.setAddres("Jalan Salak");

		AnimalDto animalSeed1 = new AnimalDto();
		animalSeed1.setNama_hewan("Luca");
		animalSeed1.setType_hewan("Kucing");
		animalSeed1.setAvailable("Tersedia");

		return (args) -> {
			adopterService.simpan(adopterSeed1);
			adopterService.simpan(adopterSeed2);
			animalService.simpan(1, animalSeed1);
		};
	}

}