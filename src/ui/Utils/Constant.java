package ui.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;

public class Constant {
    private static String lang = "fr";
    private static final ResourceBundle bundle_fr = ResourceBundle.getBundle("i18n.Lang", new Locale("fr", "FR"));
    private static final ResourceBundle bundle_en = ResourceBundle.getBundle("i18n.Lang",
            new Locale("en", "EN"));
    private static HashSet<String> langs = new HashSet<String>() {
        {
            add("fr");
            add("en");
        }
    };
    private static HashMap<String, ResourceBundle> langObj = new HashMap<String, ResourceBundle>() {
        {
            put("fr", bundle_fr);
            put("en", bundle_en);
        }
    };
    private static HashMap<String, String> constante = new HashMap<String, String>() {
        {
            put("GRAPH", "GRAPH");
            put("CURSOR", "CURSOR");
            put("LABY", "LABYRINTH");
            put("CERCLE", "CIRCLE");
            put("SEGMENT", "SEGMENT");
            put("WALL", "WALL");
            put("END", "END");
            put("START", "START");
            put("NORMAL", "NORMAL");
            put("FINAL", "FINAL");
        }
    };

    /* Public methods */

    public static void changeLang(String newLang) {
        if (langs.contains(newLang)) {
            lang = newLang;
        }
    }

    public static String getLang() {
        return lang;
    }

    public static String t(String key) {
        return langObj.get(lang).getString(key);
    }

    public static String cst(String cstSTR) {
        if (constante.containsKey(cstSTR)) {
            return constante.get(cstSTR);
        }
        System.out.println("Missing" + cstSTR); // only debug
        System.out.println("Missing" + cstSTR); // only debug
        System.out.println("Missing" + cstSTR); // only debug
        System.out.println("Missing" + cstSTR); // only debug
        System.out.println("Missing" + cstSTR); // only debug
        System.out.println("Missing" + cstSTR); // only debug
        System.out.println("Missing" + cstSTR); // only debug
        return "";
    }

    public static String convertType(String type) {
        if (type.equals("W")) {
            return Constant.cst("WALL");
        } else if (type.equals("D")) {
            return Constant.cst("START");
        } else if (type.equals("A")) {
            return Constant.cst("END");
        } else if (type.equals("F")) {
            return Constant.cst("FINAL");
        } else {
            return Constant.cst("NORMAL");
        }
    }
}
