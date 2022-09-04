package com.example.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.events.io.service.LogFileParser;
import com.example.events.service.EventsService;

@SpringBootApplication
public class LogEventsApplication implements CommandLineRunner {

	@Autowired
	private LogFileParser logFileParser;

	@Autowired
	private EventsService eventsService;

	public static void main(String[] args) {
		SpringApplication.run(LogEventsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logFileParser.parseFile("logfile.txt");

		eventsService.getAllEvents();

	}

}
