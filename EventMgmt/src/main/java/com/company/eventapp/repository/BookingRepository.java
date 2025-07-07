package com.company.eventapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.eventapp.entity.Booking;
import com.company.eventapp.entity.Event;
import com.company.eventapp.entity.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByUser(User user);
	Optional<Booking> findByUserAndEvent(User user, Event event);
	boolean existsByUserAndEvent(User user, Event event);
}
