package services;

import java.util.List;

import javax.inject.Singleton;

import controllers.forms.EventForm;
import models.Event;

/**
 * EventService
 */
@Singleton
public class EventService {
    public List<Event> findAll() {
        return Event.finder.all();
    }

    public Event makeEventFromForm(EventForm form) {
        Event event = new Event();
        event.name = form.name;
        event.article = form.article;
        return event;
    }
}