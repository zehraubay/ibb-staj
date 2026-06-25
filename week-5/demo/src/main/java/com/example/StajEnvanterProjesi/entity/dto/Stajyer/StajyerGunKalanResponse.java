package com.example.StajEnvanterProjesi.entity.dto.Stajyer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class StajyerGunKalanResponse {

    private String ad;
    private String soyad;
    private LocalDate stajBitisTarihi;
    private long gunKalan;
}
