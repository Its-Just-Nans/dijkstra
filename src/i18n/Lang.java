package i18n;

import java.util.ListResourceBundle;

public class Lang extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "ERR_MSG_INPUT", "ERR_MSG_INPUT", "Mauvaise valeur. Choix par défault " },
            { "OPTIONS", "Options" },
            { "ARRIVEE", "Arrivée" },
            { "CHANGE_COLOR_SEGMENT", "Changer la couleur du segment" },
            { "DEL_SEG", "Supprimer le segment" },
            { "QUIT", "Quit the application" },
            { "LEAVE", "Quitter" },
            { "SAVE", "Dessin non sauvé. Sauvegarder ?" },
            { "SQUARE_SIZE", "Entrer la taille des cases" },
            { "OPT_MOD", "Cette modification sera valable pour le prochain labyrinthe" },
            { "SQUARE_SIZE", "Tailles des cases du labyrinthe:" },
            { "NEW", "Nouveau" },
            { "CURSOR", "Selection" },
            { "SOLVE", "Solve" },
            { "SWITCH", "Changer" },
            { "LABY", "Labyrinthe" },
            { "FILE", "Fichier" },
            { "ABOUT", "A propos" },
            { "GRAPH", "Graphe" },
    };
}