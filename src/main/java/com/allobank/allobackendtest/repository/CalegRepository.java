package com.allobank.allobackendtest.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allobank.allobackendtest.model.Caleg;

public interface CalegRepository extends JpaRepository<Caleg, UUID> {
    List<Caleg> findByDapilNamaDapilAndPartaiNamaPartaiOrderByNomorUrut(String namaDapil, String namaPartai);
    
    List<Caleg> findByDapilNamaDapil(String namaDapil);

    List<Caleg> findByPartaiNamaPartai(String namaPartai);

    List<Caleg> findAll();
}
