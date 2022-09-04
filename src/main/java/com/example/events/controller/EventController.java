package com.example.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.events.entity.Event;
import com.example.events.service.EventsService;

@RestController
@RequestMapping("/api/v1")
public class EventController {

	@Autowired
	private EventsService eventsService;

	@GetMapping
	public List<Event> findAllEvents() {

		List<Event> events = eventsService.getAllEvents();

//		Map<String, List<Events>> map = events.stream().sorted().collect(Collectors.groupingBy(Events::getId));
//
//		Map<String, Event> responseMap = new HashMap<>();
//
//		for (Map.Entry<String, List<Events>> e : map.entrySet()) {
//			Event ed = new Event();
//
//			String id = e.getKey();
//
//			if (e.getValue().get(0).getHost() != null) {
//				ed.setHost(e.getValue().get(0).getHost());
//			}
//			if (e.getValue().get(0).getType() != null) {
//				ed.setType(e.getValue().get(0).getType());
//			}
//
//			long d = e.getValue().get(1).getTimestamp().getTime() - e.getValue().get(0).getTimestamp().getTime();
//
//			String duration = String.valueOf(d) + "s";
//			ed.setDuration(duration);
//
//			if (d > 4) {
//				ed.setAlert(true);
//			}
//
//			responseMap.put(id, ed);
//
//		}

//		EventsResponseDTO response = new EventsResponseDTO();
//		response.setEvents(responseMap);

		return events;
	}

	@GetMapping("/flagged-events")
	public List<Event> findAllFlaggedEvents() {

		return eventsService.getAllFlaggedEvents();
	}
}
