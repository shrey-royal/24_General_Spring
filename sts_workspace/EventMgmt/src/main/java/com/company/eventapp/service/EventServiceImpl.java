package com.company.eventapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.eventapp.entity.Event;
import com.company.eventapp.repository.EventRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {
	private final EventRepository repository;

	@Override
	public Event createEvent(Event event) {
		return repository.save(event);
	}

	@Override
	public List<Event> getUpcomingEvents() {
		return repository.findByEventDateAfter(LocalDateTime.now());
	}

	@Override
	public Optional<Event> getEventById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void updateSeats(Event event, int seatsToReduce) {
		int available = event.getAvailableSeats();
		if(available < seatsToReduce) {
			throw new IllegalArgumentException("Not enough seats available");
		}
		event.setAvailableSeats(available - seatsToReduce);
		repository.save(event);
	}
}
