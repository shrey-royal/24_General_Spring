package com.company.eventapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.eventapp.entity.Event;
import com.company.eventapp.service.EventService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
	private final EventService service;
	
	@PostMapping
	public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
		return ResponseEntity.ok(service.createEvent(event));
	}
	
	@GetMapping
	public ResponseEntity<List<Event>> getUpcomingEvents() {
		return ResponseEntity.ok(service.getUpcomingEvents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		return service.getEventById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
