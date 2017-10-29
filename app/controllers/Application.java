package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.Context;
import models.*;

import views.html.*;
import play.mvc.Http.MultipartFormData;
import play.data.*;
import play.data.Form.*;
import java.util.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import controllers.forms.SampleForm;

/**
 * コントローラ
 */
public class Application extends Controller {
    private Form<SampleForm> form;

    @Inject
    public Application(FormFactory formfaFactory) {
        this.form = formfaFactory.form(SampleForm.class);
    }

    public Result index() {
        return ok(index.render("何か書いて", form));
    }
    // Form<SampleForm> requestForm = form.bindFromRequest();
    
    public Result send() {
        Form<SampleForm> f;
        return null;
    }

}