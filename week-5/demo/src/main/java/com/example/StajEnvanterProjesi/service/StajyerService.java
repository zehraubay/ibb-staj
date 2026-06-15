package com.example.StajEnvanterProjesi.service;

import com.example.StajEnvanterProjesi.entity.Stajyer;
import java.util.List;

import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerResponse;
import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerRequest;
import org.springframework.stereotype.Service;

@Service
public interface StajyerService {

    StajyerResponse findById(Long id);

    List<StajyerResponse> findAll();

    Stajyer save(Stajyer request);

    StajyerResponse update(Long id, StajyerRequest request);

    void delete(Long id);


}


















//    Optional<StajyerResponse> findById(Long id);
//
//    List<StajyerResponse> findAll();
//
//    Stajyer save(Stajyer stajyer);
//
//    Stajyer update(Long id, Stajyer stajyer);
//
//    void delete(Long id);