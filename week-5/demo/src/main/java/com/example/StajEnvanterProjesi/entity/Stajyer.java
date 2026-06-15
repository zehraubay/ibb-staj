package com.example.StajEnvanterProjesi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity(name = "stajyer")
@Table(name = "stajyer")
public class Stajyer extends GenericObjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "ad", nullable = false)
    private String ad;

    @Column(name = "soyad", nullable = false)
    private String soyad;

    @Column(name = "email")
    private String email;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "universite")
    private String universite;

    @Column(name = "bolum")
    private String bolum;

    @Column(name = "sinif")
    private Integer sinif;

    @Column(name = "staj_baslangic_tarihi")
    private LocalDate stajBaslangicTarihi;

    @Column(name = "staj_bitis_tarihi")
    private LocalDate stajBitisTarihi;

    @Column(name = "durum")
    private String durum;

    @Column(name = "status")
    private Boolean status = true;



}

