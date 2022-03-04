package i18n;

import java.util.ListResourceBundle;

public class Lang_fr_FR extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "ERR_MSG_INPUT", "ERR_MSG_INPUT", "Mauvaise valeur. Choix par défault " },
            { "OPTIONS", "Options" },
            { "CHANGE_COLOR_SEGMENT", "Changer la couleur du segment" },
            { "DEL_SEG", "Supprimer le segment" },
            { "DEL_CIRCLE", "Supprimer le cercle" },
            { "QUIT", "Quit the application" },
            { "LEAVE", "Quitter" },
            { "SAVE", "Dessin non sauvé. Sauvegarder ?" },
            { "SQUARE_SIZE", "Entrer la taille des cases" },
            { "OPT_MOD", "Cette modification sera valable pour le prochain labyrinthe" },
            { "SQUARE_SIZE", "Tailles des cases du labyrinthe:" },
            { "NEW", "Nouveau" },
            { "CURSOR", "Selection" },
            { "SOLVE", "Solution" },
            { "SWITCH", "Changer" },
            { "LABY", "Labyrinthe" },
            { "FILE", "Fichier" },
            { "ABOUT", "A propos" },
            { "GRAPH", "Graphe" },
            { "SEGMENT", "Segment" },
            { "CERCLE", "Cercle" },
            { "NORMAL", "Normal" },
            { "END", "Arrivée" },
            { "START", "Départ" },
            { "WALL", "Wall" },
            { "MSG_SWITCH", "Vous êtes deja dans cet onglet" },
            { "INIT_FROM_FILE", "Ouvrir depuis un fichier" },
            { "GET_HEIGHT", "Entrer la hauteur du labyrinthe" },
            { "GET_WIDTH", "Entrer la largeur du labyrinthe" },
            { "NO_START", "Le départ n'a pas été trouvé" },
            { "NO_END", "L'arrivée n'a pas été trouvé" },
            { "SAVE_TO_FILE", "Sauvegarder le labyrinthe" },
            { "NOT_SAVED", "Le fichier n'a pas été enregistré" },
            { "IO_ERROR", "Une erreur (I/O) s'est produite" },
            { "FILE_NOT_FOUND", "Le fichier n'a pas été trouvé" },
            { "ERROR_CHAR_LINE", "Erreur dans le fichier à la ligne :" },
            { "ERROR_LINE_LEN", "Erreur avec la longueur de la ligne:" },
            { "NO_SOLUTION", "Pas de solution trouvée" },
            { "SEGMENT_VALUE", "Valeur du segment" },
            { "UPDATE_VALUE", "Actualiser la valeur" },
    };
}