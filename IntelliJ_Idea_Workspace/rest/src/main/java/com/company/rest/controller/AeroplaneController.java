package com.company.rest.controller;

import com.company.rest.entity.Aeroplane;
import com.company.rest.service.AeroplaneService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
