package controllers;

import play.mvc.*;

import views.html.*;
import play.data.*;

import java.util.List;

import javax.inject.Inject;

import controllers.forms.EventForm;
import models.Event;

/**
 * コントローラ
 */
public class Application extends Controller {
    private Form<controllers.forms.EventForm> eventForm;
    private final Event EVENT_MODEL = new Event();

    @Inject
    public Application(FormFactory formFactory) {
        this.eventForm = formFactory.form(EventForm.class);
    }

    public Result index() {
        List<Event> events = EVENT_MODEL.finder.all();
        return ok(index.render(events, eventForm));
    }

    public Result send() {
        Event event = makeEvent(eventForm.bindFromRequest().get());
        event.insert();
        return redirect("/");
    }

    private Event makeEvent(EventForm form) {
        Event event = new Event();
        event.name = form.name;
        event.message = form.message;
        return event;
    }

}