package com.company.rest.controller;

import com.company.rest.entity.Aeroplane;
import com.company.rest.service.AeroplaneService;
import com.company.rest.util.AeroplaneStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aeroplanes")
public class AeroplaneController {

    @Autowired
    private AeroplaneService service;

    @GetMapping
    public List<Aeroplane> home() {
        return service.getAll();
    }

    @PostMapping
    public Aeroplane create(@RequestBody Aeroplane aeroplane) {
        return service.create(aeroplane);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeroplane> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeroplane> update(@PathVariable Long id, @RequestBody Aeroplane updated) {
        try {
            return ResponseEntity.ok(service.update(id, updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Aeroplane>> getById(@PathVariable AeroplaneStatus status) {

        try {
            return ResponseEntity.ok(service.findByStatus(status));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
