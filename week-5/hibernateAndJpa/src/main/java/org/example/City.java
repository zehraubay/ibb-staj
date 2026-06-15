package org.example;

// package com.javacourse.proect.hibernateAndJpa.Entities
// import javax.persistence.*;

@Entity
@Table(name="city")

public class City {

    @Id
    @Column(name="ID") //hangi kolona denk geldiği
    @GeneratedValue(strategy=GenerationType.IDENTITY) //id'nin primary key'in otomatik üretilmesini sağlar. id alanının değerini veritabanının otomatik artırmasını sağlar.
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="countrycode")
    private String countryCode;

    @Column(name="district")
    private String district;

    @Column(name="population")
    private int population;

    //Constructor
    public City() {int id,String name, String countryCode, String district,int population;}

    this.id=id;
    this.name=name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;

}

//parametresiz constructor
public City(){

}

public int getId(){
    return id;
}

public void setId(int id){
    this.id = id;
}