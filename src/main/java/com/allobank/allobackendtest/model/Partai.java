package com.allobank.allobackendtest.model;

import lombok.Data;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Partai {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String namaPartai;
    private Integer nomorUrut;
}
