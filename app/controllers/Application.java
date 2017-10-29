package controllers;

import controllers.form.SampleForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * コントローラ
 */
public class Application extends Controller {
    public Result index() {           
        return ok(index.render("何か書いて",new Form<>(SampleForm.class)));
    }

    public Result send() {
        Form<SampleForm> f;
        return null;
    }

}