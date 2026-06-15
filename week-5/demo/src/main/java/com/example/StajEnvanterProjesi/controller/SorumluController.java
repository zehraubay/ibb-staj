package com.example.StajEnvanterProjesi.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.StajEnvanterProjesi.entity.dto.Sorumlu.SorumluRequest;
import com.example.StajEnvanterProjesi.entity.dto.Sorumlu.SorumluResponse;
import com.example.StajEnvanterProjesi.service.SorumluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sorumlu")
public class SorumluController {

    @Autowired
    private SorumluService sorumluService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<SorumluResponse> getById(@PathVariable("id") Long id) {
        SorumluResponse response = sorumluService.findById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SorumluResponse>> getAll() {
        return ResponseEntity.ok(sorumluService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<SorumluResponse> save(@RequestBody SorumluRequest request) {
        return ResponseEntity.ok(sorumluService.save(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SorumluResponse> update(@PathVariable Long id,
                                                  @RequestBody SorumluRequest request) {
        SorumluResponse response = sorumluService.update(id, request);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        sorumluService.delete(id);
        return ResponseEntity.ok().build();
    }
}
