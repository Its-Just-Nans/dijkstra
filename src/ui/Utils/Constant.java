package ui.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class Constant {
    public static String lang = "fr";
    private static final ResourceBundle bundle_fr = ResourceBundle.getBundle("i18n.Lang", new Locale("fr", "FR"));
    private static final ResourceBundle bundle_en = ResourceBundle.getBundle("i18n.Lang", new Locale("en", "EN"));
    public static String ARRIVEE = "Arrivée";
    public static String DEPART = "Depart";
    public static String NORMAL = "Normal";
    public static String MUR = "Mur";
    public static HashSet<String> langs = new HashSet<String>() {
        {
            add("fr");
            add("en");
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

    public static String CERCLE = "Cercle";
    public static String SEGMENT = "Segment";
    public static String CURSOR = "Cursor";
    public static String LABY = "Labyrinthe";
    public static String GRAPH = "Graphe";
    public static String NEW = "Nouveau";
    public static String ACTIVATE = "Activer";
    public static String SOLVE = "Solution";

    public static String DIJKSTRA = "Dijkstra";
    public static String SWITCH = "Switch";
    public static String OPTIONS = "Options";

    public static HashMap<String, ResourceBundle> langObj = new HashMap<String, ResourceBundle>() {
        {
            put("fr", bundle_fr);
            put("en", bundle_en);
        }
    };
}
