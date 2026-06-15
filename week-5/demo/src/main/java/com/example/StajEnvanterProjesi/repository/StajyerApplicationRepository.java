package com.example.StajEnvanterProjesi.repository;

import com.example.StajEnvanterProjesi.entity.Stajyer;
import com.example.StajEnvanterProjesi.entity.Sorumlu;
import com.example.StajEnvanterProjesi.entity.StajyerApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StajyerApplicationRepository extends JpaRepository<StajyerApplication, Long> {

    Optional<StajyerApplication> findByStajyersAndStatusTrue(Stajyer stajyer);

    Optional<StajyerApplication> findTopByStajyersOrderByIdDesc(Stajyer stajyer);

    //Asil Sorumluyu bulma
    Optional<StajyerApplication> findByStajyersAndAsilMiTrueAndStatusTrue(Stajyer stajyer);

    //Yedek sorumluyu bulma
    Optional<StajyerApplication> findByStajyersAndAsilMiFalseAndStatusTrue(Stajyer stajyer);

    // Bu sorumlu başka bir stajyere asil olarak atanmış mı
    Optional<StajyerApplication> findBySorumlusAndAsilMiTrueAndStatusTrue(Sorumlu sorumlu);

    StajyerApplication findByStatusTrueAndStajyers_Id(Long stajyerId);

}

