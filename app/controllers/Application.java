package controllers;

import play.mvc.*;
import services.EventService;
import views.html.*;
import play.data.*;

import javax.inject.Inject;

import controllers.forms.EventForm;
import models.Participant;

/**
 * コントローラ
 */
public class Application extends Controller {
    private Form<EventForm> eventForm;
    private Form<Participant> perticipantForm;

    @Inject
    private EventService eventService;

    @Inject
    public Application(FormFactory formFactory) {
        this.eventForm = formFactory.form(EventForm.class);
        this.perticipantForm = formFactory.form(Participant.class);
    }

    public Result index() {
        return ok(index.render(eventService.findAll(), eventForm));
    }

    public Result send() {
        eventService.makeEventFromForm(eventForm.bindFromRequest().get()).insert();
        return redirect("/");
    }

    // public Result participant() {

    // }
}