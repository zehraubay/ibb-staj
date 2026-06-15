package com.example.StajEnvanterProjesi.service;

import com.example.StajEnvanterProjesi.entity.dto.Sorumlu.SorumluRequest;
import com.example.StajEnvanterProjesi.entity.dto.Sorumlu.SorumluResponse;
import java.util.List;



public interface SorumluService {

        SorumluResponse findById(Long id);

        List<SorumluResponse> findAll();

        SorumluResponse save(SorumluRequest request);

        SorumluResponse update(Long id, SorumluRequest request);

        void delete(Long id);

}
