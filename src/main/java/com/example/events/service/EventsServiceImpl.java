package com.example.events.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.events.entity.Event;
import com.example.events.repository.EventsRepository;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsRepository eventsRepository;

	@Override
	public List<Event> getAllEvents() {

		Iterable<Event> events = eventsRepository.findAll();

		List<Event> list = new ArrayList<>();

		for (Event e : events) {
			list.add(e);
		}

		return list;
	}

	@Override
	public List<Event> getAllFlaggedEvents() {

		return getAllEvents().stream().filter(e -> e.isAlert()).collect(Collectors.toList());

	}

}
