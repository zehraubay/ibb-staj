package com.example.StajEnvanterProjesi.service;

import com.example.StajEnvanterProjesi.entity.StajyerApplication;
import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerGunKalanResponse;

import java.util.List;

public interface StajyerApplicationService {

    StajyerApplication findById(Long id);

    List<StajyerApplication> findAll();

    StajyerApplication stajyerKaydet(Long stajyerId, Long sorumluId);

    StajyerApplication sorumluAyril(Long stajyerId);

    StajyerApplication yeniSorumluAta(Long stajyerId, Long SorumluId);

    void delete(Long id);

    StajyerApplication yedekSorumluEkle(Long stajyerId, Long sorumluId);

    List<StajyerGunKalanResponse> gunKalanHesapla();
}
