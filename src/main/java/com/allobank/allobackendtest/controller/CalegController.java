package com.allobank.allobackendtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.service.CalegService;

@RestController
public class CalegController {
    @Autowired
    private CalegService calegService;

    @GetMapping("/caleg")
    public List<Caleg> getCalegList(
            @RequestParam(required = false) String namaDapil,
            @RequestParam(required = false) String namaPartai) {
        if (namaDapil != null && namaPartai != null) {
            return calegService.getCalegListByDapilAndPartai(namaDapil, namaPartai);
        } else {
            return calegService.getAllCaleg();
        }
    }
    @GetMapping("/caleg/all")
    public List<Caleg> getAllCaleg() {
        return calegService.getAllCaleg();
    }

    @GetMapping("/caleg/byNamaDapil")
    public List<Caleg> getCalegByNamaDapil(@RequestParam String namaDapil) {
        return calegService.getCalegByNamaDapil(namaDapil);
    }

    @GetMapping("/caleg/byNamaPartai")
    public List<Caleg> getCalegByNamaPartai(@RequestParam String namaPartai) {
        return calegService.getCalegByNamaPartai(namaPartai);
    }
}
