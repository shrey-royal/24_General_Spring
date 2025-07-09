package com.company.eventapp.service;

import java.util.List;

import com.company.eventapp.entity.Booking;
import com.company.eventapp.entity.Event;
import com.company.eventapp.entity.User;

public interface BookingService {
	Booking bookEvent(User user, Event event);
	List<Booking> getBookingsByUser(User user);
}
