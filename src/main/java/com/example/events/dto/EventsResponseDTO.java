package com.example.events.dto;

import java.util.Map;

import com.example.events.bean.DataTransferObject;
import com.example.events.entity.Event;

public class EventsResponseDTO implements DataTransferObject {

	private Map<String, Event> events;

	public Map<String, Event> getEvents() {
		return events;
	}

	public void setEvents(Map<String, Event> events) {
		this.events = events;
	}

}
