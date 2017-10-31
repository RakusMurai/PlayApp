package controllers;

import play.mvc.*;
import views.html.*;
import play.data.*;

import javax.inject.Inject;

import controllers.forms.EventForm;
import controllers.forms.ParticipantForm;
import models.Event;
import models.Participant;

/** アプリケーションコントローラー. */
public class Application extends Controller {
    /** フォームクラスの変数準備 */
    private Form<EventForm> eventForm;
    private Form<ParticipantForm> perticipantForm;

    /** フォームクラスにフォームを代入. */
    @Inject
    public Application(FormFactory formFactory) {
        this.eventForm = formFactory.form(EventForm.class);
        this.perticipantForm = formFactory.form(ParticipantForm.class);
    }

    /** トップページの表示. */
    public Result index() {
        return ok(index.render(Event.finder.all(), eventForm));
    }

    /** イベントの登録. */
    public Result event() {
        new Event(eventForm.bindFromRequest().get()).insert();
        return redirect("/");
    }

    /** 参加者の登録. */
    public Result participant() {
        new Participant(perticipantForm.bindFromRequest().get()).insert();
        return redirect("/");
    }
}