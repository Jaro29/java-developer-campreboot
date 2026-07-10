package pl.coderslab.advanced.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandardUrl implements Url {

    @Override
    public String getParam(String name, String url) {
        Matcher m = Pattern.compile(name + "=([^&]+)").matcher(url);
        return m.find() ? m.group(1) : "";
    }
}
