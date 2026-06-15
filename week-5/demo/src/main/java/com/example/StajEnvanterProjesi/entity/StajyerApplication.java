package com.example.StajEnvanterProjesi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity(name = "stajyerApplication")
@Table(name ="stajyer_application")
@Data

public class StajyerApplication extends GenericObjectEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Stajyer_id", nullable = false)
    private Stajyer stajyers;

    @ManyToOne
    @JoinColumn(name = "Sorumlu_id", nullable = true)
    private Sorumlu sorumlus;

//    @ManyToOne
//     @JoinColumn(name = "yedekSorumlu_id")

    @Column(name = "asilMi")
    private Boolean asilMi = true;


}
