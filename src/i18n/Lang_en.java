package i18n;

import java.util.ListResourceBundle;

public class Lang_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "ERR_MSG_INPUT", "Bad value. Choix par défault " },
            { "OPTIONS", "Options" },
            { "DEL_SEG", "Erase segment" },
            { "CHANGE_COLOR_SEGMENT", "Change color segment" },
            { "QUIT", "Quitter l'application" },
            { "LEAVE", "Leave" },
            { "SAVE", "Drawing not saved. Save ?" },
            { "SQUARE_SIZE", "Enter size of labyrinth square" },
            { "OPT_MOD", "Enter size of labyrinth square" },
            { "SQUARE_SIZE", "Labyrinth square's size:" },
            { "NEW", "New" },
            { "CURSOR", "Cursor" },
            { "SOLVE", "Solution" },
            { "SWITCH", "Switch" },
            { "LABY", "Labyrinth" },
            { "FILE", "File" },
            { "ABOUT", "About" },
            { "GRAPH", "Graph" },
            { "SEGMENT", "Segment" },
            { "CERCLE", "Circle" },
            { "NORMAL", "Normal" },
            { "END", "End" },
            { "START", "Start" },
            { "WALL", "Wall" },
            { "MSG_SWITCH", "You are already in the correct tab" },
    };
}