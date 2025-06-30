package com.company.rest.service;

import com.company.rest.entity.Aeroplane;
import com.company.rest.repository.AeroplaneRepository;
import com.company.rest.util.AeroplaneStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeroplaneService {
    @Autowired
    private AeroplaneRepository repository;

    public List<Aeroplane> getAll() {
        return repository.findAll();
    }

    public Optional<Aeroplane> getById(Long id) {
        return repository.findById(id);
    }

    public Aeroplane create(Aeroplane aeroplane) {
        return repository.save(aeroplane);
    }

    public Aeroplane update(Long id, Aeroplane aeroplane) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setModel(aeroplane.getModel());
                    existing.setManufacturer(aeroplane.getManufacturer());
                    existing.setCapacity(aeroplane.getCapacity());
                    existing.setStatus(aeroplane.getStatus());
                    return repository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Aeroplane not found with id: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Aeroplane> findByStatus(AeroplaneStatus status) {
        return repository.findByStatus(status);
    }
}
