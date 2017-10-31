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
    private final Article ARTICLE_MODEL = new Article();

    @Inject
    public Application(FormFactory formFactory) {
        this.articleForm = formFactory.form(ArticleForm.class);
    }

    public Result index() {
        List<Article> articles = ARTICLE_MODEL.finder.all();
        return ok(index.render(articles, articleForm));
    }

    public Result send() {
        ArticleForm reqestForm = articleForm.bindFromRequest().get();
        Article article = new Article();
        article.name = reqestForm.name;
        article.message = reqestForm.message;
        article.insert();
        return redirect("/");
    }

}