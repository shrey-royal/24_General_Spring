package com.company.eventapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.eventapp.entity.Booking;
import com.company.eventapp.entity.Event;
import com.company.eventapp.entity.User;
import com.company.eventapp.service.BookingService;
import com.company.eventapp.service.EventService;
import com.company.eventapp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
	
	private final BookingService bookingService;
	private final EventService eventService;
	private final UserService userService;
	
	@PostMapping("/{eventId}")
	public ResponseEntity<?> bookEvent(@PathVariable Long eventId, @RequestBody String username) {
		System.out.println("Username: " + username);
		User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
		Event event = eventService.getEventById(eventId).orElse(null);
		if(event == null) return ResponseEntity.notFound().build();
		
		try {
			Booking booking = bookingService.bookEvent(user, event);
			return ResponseEntity.ok(booking);
		} catch (IllegalStateException | IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/my")
	public ResponseEntity<List<Booking>> myBookings(@RequestBody String username) {
		User user = userService.findByUsername(username).orElseThrow();
		return ResponseEntity.ok(bookingService.getBookingsByUser(user));
	}
}
