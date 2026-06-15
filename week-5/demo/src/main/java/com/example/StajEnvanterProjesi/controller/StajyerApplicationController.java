package com.example.StajEnvanterProjesi.controller;

import com.example.StajEnvanterProjesi.entity.StajyerApplication;
import com.example.StajEnvanterProjesi.service.StajyerApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stajyerApplication")
public class StajyerApplicationController {

    @Autowired
    private StajyerApplicationService stajyerApplicationService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<StajyerApplication>
    getById(@PathVariable Long id) {

        StajyerApplication response =
                stajyerApplicationService.findById(id);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StajyerApplication>>
    getAll() {

        return ResponseEntity.ok(
                stajyerApplicationService.findAll()
        );
    }


    @PostMapping("/save/{stajyerId}/{sorumluId}")
    public ResponseEntity<String> save(
            @PathVariable Long stajyerId,
            @PathVariable Long sorumluId) {

        try {
            StajyerApplication kayit =
                    stajyerApplicationService.stajyerKaydet(stajyerId, sorumluId);

            return ResponseEntity.ok(kayit.toString());

        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // Yedek sorumlu ekle
    // POST /stajyerApplication/yedekEkle/1/8
    @PostMapping("/yedekEkle/{stajyerId}/{sorumluId}")
    public ResponseEntity<StajyerApplication> yedekEkle(
            @PathVariable Long stajyerId,
            @PathVariable Long sorumluId) {
        return ResponseEntity.ok(
                stajyerApplicationService.yedekSorumluEkle(stajyerId, sorumluId));
    }

    @PutMapping("/sorumluAyril/{stajyerId}")
    public ResponseEntity<String> sorumluAyril(@PathVariable Long stajyerId) {
        String mesaj = stajyerApplicationService.sorumluAyril(stajyerId);
        return ResponseEntity.ok(mesaj);
    }

//    @PutMapping("/sorumluAyril/{stajyerId}")
//    public ResponseEntity<Void> sorumluAyril(@PathVariable Long stajyerId) {
//        stajyerApplicationService.sorumluAyril(stajyerId);
//        return ResponseEntity.ok().build();
//    }


    @PostMapping("/sorumluAta/{stajyerId}/{sorumluId}")
    public ResponseEntity<StajyerApplication> sorumluAta(
            @PathVariable Long stajyerId,
            @PathVariable Long sorumluId) {
        StajyerApplication kayit = stajyerApplicationService.yeniSorumluAta(stajyerId, sorumluId);
        return ResponseEntity.ok(kayit);
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<Void>
    delete(@PathVariable Long id) {

        stajyerApplicationService.delete(id);

        return ResponseEntity.ok().build();
    }
}








//
//@PostMapping("/save")
//public ResponseEntity<StajyerApplication>
//save(@RequestBody StajyerApplication stajyerApplication) {
//
//    return ResponseEntity.ok(
//            stajyerApplicationService.save(stajyerApplication)
//    );
//}
//
//@PutMapping("/update/{id}")
//public ResponseEntity<StajyerApplication>
//update(@PathVariable Long id,
//       @RequestBody StajyerApplication stajyerApplication) {
//
//    StajyerApplication response =
//            stajyerApplicationService.update(
//                    id,
//                    stajyerApplication);
//
//    if (response == null) {
//        return ResponseEntity.notFound().build();
//    }
//
//    return ResponseEntity.ok(response);
//}