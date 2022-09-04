package com.example.events.io.service;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.events.entity.Event;
import com.example.events.entity.Events;
import com.example.events.repository.EventsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LogFileParserImpl implements LogFileParser {

	private static final Logger logger = LoggerFactory.getLogger(LogFileParserImpl.class);

	@Autowired
	private EventsRepository eventsRepository;

	@Override
	public void parseFile(String file) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		List<Events> allEvents = new ArrayList<>();
		List<Event> list;
		ObjectMapper mapper = new ObjectMapper();
		try {
			inputStream = new FileInputStream(file);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				
				Events event = mapper.readValue(line, Events.class);

				allEvents.add(event);

			}

			list = addToEventList(allEvents);

			eventsRepository.saveAll(list);

			if (sc.ioException() != null) {
				
				logger.debug(file);
				throw sc.ioException();
			}
		} catch (FileNotFoundException e) {
			// log
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}

	}

	private List<Event> addToEventList(List<Events> allEvents) {

		Map<String, List<Events>> map = allEvents.stream().sorted().collect(Collectors.groupingBy(Events::getId));

		List<Event> list;

		list = map.entrySet().stream().map(e -> getFlaggedEvent(e)).collect(Collectors.toList());


		return list;
	}

	private Event getFlaggedEvent(Entry<String, List<Events>> e) {

		long duration = e.getValue().get(1).getTimestamp().getTime() - e.getValue().get(0).getTimestamp().getTime();

		Event event = new Event();
		event.setId(e.getKey());
		event.setDuration(String.valueOf(duration) + "s");
		if (duration > 4) {
			event.setAlert(true);
		}

		if (e.getValue().get(0).getHost() != null) {
			event.setHost(e.getValue().get(0).getHost());
		}
		if (e.getValue().get(0).getType() != null) {
			event.setType(e.getValue().get(0).getType());
		}

		return event;
	}

}
