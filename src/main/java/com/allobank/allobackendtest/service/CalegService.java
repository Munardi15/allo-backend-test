package com.allobank.allobackendtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.repository.CalegRepository;

@Service
public class CalegService {
    @Autowired
    private CalegRepository calegRepository;

    public List<Caleg> getCalegListByDapilAndPartai(String namaDapil, String namaPartai) {
        return calegRepository.findByDapilNamaDapilAndPartaiNamaPartaiOrderByNomorUrut(namaDapil, namaPartai);
    }
    public List<Caleg> getAllCaleg() {
        return calegRepository.findAll();
    }

    public List<Caleg> getCalegByNamaDapil(String namaDapil) {
        return calegRepository.findByDapilNamaDapil(namaDapil);
    }

    public List<Caleg> getCalegByNamaPartai(String namaPartai) {
        return calegRepository.findByPartaiNamaPartai(namaPartai);
    }
}
