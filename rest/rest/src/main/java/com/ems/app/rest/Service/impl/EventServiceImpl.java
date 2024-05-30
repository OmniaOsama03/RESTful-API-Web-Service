package com.ems.app.rest.Service.impl;

import java.util.List;

import com.ems.app.rest.Exception.ResourceNotFoundException;
import com.ems.app.rest.Model.Event;
import com.ems.app.rest.Respository.EventRepository;
import com.ems.app.rest.Service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository) {
        super();
        this.eventRepository = eventRepository;
    }
    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    @Override
    public Event getEventById(long id) {
        /*
         * Optional<Event> event = eventRepository.findById(id);
         * if(event.isPresent()) {
         * return event.get();
         * } else throw new ResourceNotFoundException("Event", "Id", id);
         */
        /*
         * OR just one line using lambda expression
         * Lambda expressions are commonly used in Java to define inline implementations of functional
         * interfaces, such as those used in streams, forEach loops, and method references. They provide
         * a concise way to represent anonymous functions.
         */
        return eventRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Event", "Id", id));
    }

    @Override
    public Event updateEvent(Event event, long id) {
// we need to check whether event with given id exists in DB or not
        Event existingEvent = eventRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));
        existingEvent.setTitle(event.getTitle());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setDate(event.getDate());
        existingEvent.setCategory(event.getCategory());
        existingEvent.setStatus(event.getStatus());
        existingEvent.setCapacity(event.getCapacity());
// save updated event to DB
        eventRepository.save(existingEvent);
        return existingEvent;
    }

    @Override
    public void deleteEvent(long id) {
// check whether a event exist in a DB or not
        eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        eventRepository.deleteById(id);
    }
}
