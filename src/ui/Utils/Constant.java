package ui.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;

public class Constant {
    public static String lang = "fr";
    private static final ResourceBundle bundle_fr = ResourceBundle.getBundle("i18n.Lang", new Locale("fr", "FR"));
    private static final ResourceBundle bundle_en = ResourceBundle.getBundle("i18n.Lang", new Locale("en", "EN"));
    public static HashSet<String> langs = new HashSet<String>() {
        {
            add("fr");
            add("en");
        }
    };
    public static HashMap<String, ResourceBundle> langObj = new HashMap<String, ResourceBundle>() {
        {
            put("fr", bundle_fr);
            put("en", bundle_en);
        }
    };

    public static void changeLang(String newLang) {
        if (langs.contains(newLang)) {
            lang = newLang;
        }
    }

    public static String t(String key) {
        return langObj.get(lang).getString(key);
    }

}
