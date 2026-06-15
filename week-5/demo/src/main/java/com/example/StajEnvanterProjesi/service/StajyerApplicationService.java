package com.example.StajEnvanterProjesi.service;

import com.example.StajEnvanterProjesi.entity.StajyerApplication;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StajyerApplicationService {

    StajyerApplication findById(Long id);

    List<StajyerApplication> findAll();

    StajyerApplication stajyerKaydet(Long stajyerId, Long sorumluId) throws Exception;

    String sorumluAyril(Long stajyerId);

    StajyerApplication yeniSorumluAta(Long stajyerId, Long SorumluId);

    void delete(Long id);

    StajyerApplication yedekSorumluEkle(Long stajyerId, Long sorumluId);
}
