package com.royal.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.royal.data.entity.Train;
import com.royal.data.repository.TrainRepository;

@Service
public class TrainService {
	private final TrainRepository repository;
	
	public TrainService(TrainRepository repository) {
		this.repository = repository;
	}
	
	public List<Train> listAll() {
		return repository.findAll();
	}
	
	public Train get(int id) {
		return repository.findById(id);
	}
	
	public void save(Train train) {
		repository.save(train);
	}
	
	public void update(Train train) {
		repository.update(train);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
