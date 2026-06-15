package com.example.StajEnvanterProjesi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name = "sorumlu")
@Table(name = "sorumlu")
public class Sorumlu extends GenericObjectEntity implements Serializable {
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

}
