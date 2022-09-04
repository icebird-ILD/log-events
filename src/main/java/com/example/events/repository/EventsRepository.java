package com.example.events.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.events.entity.Event;

@Repository
public interface EventsRepository extends CrudRepository<Event, String> {

}
