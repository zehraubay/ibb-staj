package com.example.StajEnvanterProjesi.entity.dto.Stajyer;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StajyerRequest {

        private String ad;

        private String soyad;

        private String email;

        private String telefon;

        private String universite;

        private String bolum;

        private Integer sinif;

        private LocalDate stajBaslangicTarihi;

        private LocalDate stajBitisTarihi;

        private String durum;
    }
