package com.example.StajEnvanterProjesi.repository;

import com.example.StajEnvanterProjesi.entity.Sorumlu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SorumluRepository extends JpaRepository<Sorumlu, Long> {

}