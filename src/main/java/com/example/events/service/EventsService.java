package com.example.events.service;

import java.util.List;

import com.example.events.entity.Event;

public interface EventsService {

	List<Event> getAllEvents();

	List<Event> getAllFlaggedEvents();

}
