package com.example.StajEnvanterProjesi.controller;

import com.example.StajEnvanterProjesi.entity.Stajyer;
import com.example.StajEnvanterProjesi.service.StajyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerResponse;
import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stajyer")
public class StajyerController {

    @Autowired
    StajyerService stajyerService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<StajyerResponse> getById(@PathVariable("id") Long id) {
        StajyerResponse response = stajyerService.findById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StajyerResponse>> getAll() {
        return ResponseEntity.ok(stajyerService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<StajyerResponse> save(@RequestBody Stajyer request) {
        stajyerService.save(request);
        return ResponseEntity.ok(stajyerService.findById(request.getId()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StajyerResponse> update(@PathVariable Long id,
                                                  @RequestBody StajyerRequest request) {
        StajyerResponse response = stajyerService.update(id, request);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        stajyerService.delete(id);
        return ResponseEntity.ok().build();
    }
}









































//@RestController
//@RequestMapping("/stajyer")
//public class StajyerController {
//
//    @Autowired
//    StajyerService stajyerService;
//
//    @GetMapping("/getById/{id}")
//    public ResponseEntity<Optional<StajyerResponse>> getById(@PathVariable ("id") Long id) {
//        Optional<StajyerResponse> stajyer = stajyerService.findById(id);
//
//        return ResponseEntity.ok(stajyer);
//    }
//
//    @GetMapping("/getAll")
//    public List<StajyerResponse> getAll() {
//        return stajyerService.findAll();
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<Stajyer> save(@RequestBody Stajyer stajyer) {
//        stajyerService.save(stajyer);
//        return ResponseEntity.ok(stajyer);
//    }
//
//
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Stajyer> update(@PathVariable Long id, @RequestBody Stajyer stajyer) {
//        Stajyer updatedStajyer = stajyerService.update(id, stajyer);
//
//        if (updatedStajyer == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedStajyer);
//    }
//
//    @PutMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
//        stajyerService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//
//
//}
