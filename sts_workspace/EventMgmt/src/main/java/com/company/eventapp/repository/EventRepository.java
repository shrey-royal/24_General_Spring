package com.company.eventapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.eventapp.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByEventDateAfter(LocalDateTime now);
	List<Event> findByTitleContainingIgnoreCase(String keyword);
}
