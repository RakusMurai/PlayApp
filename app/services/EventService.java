package services;

import java.util.List;

import javax.inject.Inject;

import controllers.forms.EventForm;
import models.Event;

/**
 * EventService
 */
public class EventService {
    public Event event;

    @Inject
    public EventService(Event event) {
        this.event = event;
    }

    public List<Event> findAll() {
        return event.finder.all();
    }

    public Event makeEventFromForm(EventForm form) {
        Event event = new Event();
        event.name = form.name;
        event.message = form.message;
        return event;
    }
}