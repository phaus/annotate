/**
 * ApplicationHelper
 * 12.05.2012
 * @author Philipp Haussleiter
 *
 */
package helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import play.classloading.enhancers.LocalvariablesNamesEnhancer.LocalVariablesNamesTracer;
import play.templates.Template;
import play.templates.TemplateLoader;

public class ApplicationHelper {

    public static String minify(String string) {
        return string.replace("\n", "").replace("\t", "    ").replace("    ", "");
    }

    public static String renderAsString(String templateName, Object... args) {
        Template template = TemplateLoader.load(templateName);
        Map<String, Object> templateBinding = new HashMap<String, Object>(16);
        for (Object o : args) {
            List<String> names = LocalVariablesNamesTracer.getAllLocalVariableNames(o);
            for (String name : names) {
                templateBinding.put(name, o);
            }
        }
        return template.render(templateBinding);
    }
}
