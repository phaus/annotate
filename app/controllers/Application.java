package controllers;

import helpers.ApplicationHelper;
import play.Logger;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        //String scriptContent = IO.readContentAsString(new File(Play.applicationPath+"/public/js/bm.js")).trim();
        String scriptContent = ApplicationHelper.renderAsString("Application/bookmarklet.js");
        String script = ApplicationHelper.minify(scriptContent);
        render(script);
    }

    public static void input() {
        String url = request.params.get("u");
        String t = request.params.get("t");
        render("Application/input.js", url, t);
    }
}
