package controllers;

import play.mvc.*;

import views.html.*;
import play.data.*;

import javax.inject.Inject;

import controllers.forms.SampleForm;

/**
 * コントローラ
 */
public class Application extends Controller {
    private Form<SampleForm> form;

    @Inject
    public Application(FormFactory formFactory) {
        this.form = formFactory.form(SampleForm.class);
    }

    public Result index() {
        return ok(index.render("何か書いて", form));
    }
    
    public Result send() {
        SampleForm sampleForm = form.bindFromRequest().get();
        return ok(index.render(sampleForm.getMessage(), form.fill(sampleForm)));        
    }

}