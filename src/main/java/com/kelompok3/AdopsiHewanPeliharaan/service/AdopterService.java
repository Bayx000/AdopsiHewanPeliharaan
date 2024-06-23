package com.kelompok3.AdopsiHewanPeliharaan.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelompok3.AdopsiHewanPeliharaan.dto.AdopterDto;
import com.kelompok3.AdopsiHewanPeliharaan.dto.Mapper;
import com.kelompok3.AdopsiHewanPeliharaan.model.Adopter;
import com.kelompok3.AdopsiHewanPeliharaan.repository.AdopterRepo;

@Service
public class AdopterService {
    @Autowired
    AdopterRepo adopterRepo;

    public AdopterDto simpan(AdopterDto adopterDto) {
        Adopter adopter = Mapper.mapAdopter(adopterDto);
        return Mapper.mapAdopterDto(adopterRepo.save(adopter));
    }
    public List<AdopterDto> semua() {
        List<Adopter> semua = adopterRepo.findAll();
        return semua.stream().map(Mapper::mapAdopterDto).collect(Collectors.toList());
    }

    public AdopterDto satu(Integer id) {
        Optional<Adopter> satu = adopterRepo.findById(id);
        return Mapper.mapAdopterDto(satu.get());
    }

    public AdopterDto ubah(Integer id, AdopterDto adopterDto) {
        Optional<Adopter> adopter = adopterRepo.findById(id);

        Adopter _Adopter = adopter.get();
        _Adopter.setNama(adopterDto.getNama());
        _Adopter.setEmail(adopterDto.getEmail());
        _Adopter.setNomor_telepon(adopterDto.getNomor_telepon());
        _Adopter.setAddres(adopterDto.getAddres());
        adopterRepo.save(_Adopter);

        return Mapper.mapAdopterDto(_Adopter);
    }

    public void hapus(Integer id) {
        adopterRepo.deleteById(id);
    }
}
