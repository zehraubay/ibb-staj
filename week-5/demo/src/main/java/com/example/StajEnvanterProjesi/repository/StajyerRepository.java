package com.example.StajEnvanterProjesi.repository;

import com.example.StajEnvanterProjesi.entity.Stajyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.time.LocalDate;

import java.util.List;

@Repository
public interface StajyerRepository extends JpaRepository<Stajyer, Long> {
        Optional<Stajyer> findByEmailAndStatusTrue(String email);

        List<Stajyer> findByDurumAndStatusTrueAndStajBitisTarihiBetween(
                String durum,
                LocalDate baslangic,
                LocalDate bitis
        );
}
