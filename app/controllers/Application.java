package controllers;

import play.mvc.*;
import services.EventService;
import views.html.*;
import play.data.*;

import javax.inject.Inject;

import controllers.forms.EventForm;

/**
 * コントローラ
 */
public class Application extends Controller {
    private Form<controllers.forms.EventForm> eventForm;

    @Inject
    private EventService eventService;

    @Inject
    public Application(FormFactory formFactory) {
        this.eventForm = formFactory.form(EventForm.class);
    }

    public Result index() {
        return ok(index.render(eventService.findAll(), eventForm));
    }

    public Result send() {
        eventService.makeEventFromForm(eventForm.bindFromRequest().get()).insert();
        return redirect("/");
    }
}