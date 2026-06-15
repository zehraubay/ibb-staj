package org.example;
// package com.javacourse.proect.hibernateAndJpa.Entities.City;

public interface ICityDal {
    List<City> getAll(); //bütün şehirleri listeleyecek kod
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
}

//interface'yi hibernate kodunu kullanarak yazmamız gerekiyor
