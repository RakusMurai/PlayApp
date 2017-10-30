package controllers;

import play.mvc.*;

import views.html.*;
import play.data.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import controllers.forms.ArticleForm;
import models.Article;

/**
 * コントローラ
 */
public class Application extends Controller {
    private Form<ArticleForm> articleForm;

    @Inject
    public Application(FormFactory formFactory) {
        this.articleForm = formFactory.form(ArticleForm.class);
    }

    public Result index() {
        List<Article> articles = new ArrayList<>();
        return ok(index.render("何か書いて", articleForm));
    }

    public Result send() {
        ArticleForm reqestForm = articleForm.bindFromRequest().get();
        return ok(index.render(reqestForm.name, articleForm.fill(reqestForm)));
    }

}