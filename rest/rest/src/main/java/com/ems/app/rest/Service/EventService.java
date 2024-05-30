package com.ems.app.rest.Service;

import com.ems.app.rest.Model.Event;

import java.util.List;

public interface EventService
{
    Event saveEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(long id);
    Event updateEvent(Event event, long id);
    void deleteEvent(long id);


}
