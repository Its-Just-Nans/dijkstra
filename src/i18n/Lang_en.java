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
            { "DEL_CIRCLE", "Erase circle" },
            { "CHANGE_COLOR_SEGMENT", "Change color segment" },
            { "QUIT", "Quitter l'application" },
            { "LEAVE", "Leave" },
            { "SAVE", "Drawing not saved. Save ?" },
            { "SQUARE_SIZE", "Enter size of labyrinth square" },
            { "OPT_MOD", "This modification will be set for the next labyrinth" },
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
            { "INIT_FROM_FILE", "Init from file" },
            { "GET_HEIGHT", "Enter the height of the labyrinth" },
            { "GET_WIDTH", "Enter the width of the labyrinth" },
            { "NO_START", "Start can't be found !" },
            { "NO_END", "End can't be found !" },
    };
}