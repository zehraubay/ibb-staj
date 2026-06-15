package com.example.StajEnvanterProjesi.entity.dto.Stajyer;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StajyerResponse {

    private Long id;

    private String ad;

    private String soyad;

    private String universite;

    private String bolum;

    private Integer sinif;

    private LocalDate stajBaslangicTarihi;

    private LocalDate stajBitisTarihi;

    private String durum;

    private Boolean status;
}
