package i18n;

import java.util.ListResourceBundle;

public class Lang_en_EN extends ListResourceBundle {

    /**
     * @return Object[][]
     */
    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "ERR_MSG_INPUT", "Bad value. Default choice" },
            { "OPTIONS", "Options" },
            { "DEL_SEG", "Erase segment" },
            { "DEL_CIRCLE", "Erase circle" },
            { "CHANGE_COLOR_SEGMENT", "Change color segment" },
            { "QUIT", "Quitter l'application" },
            { "LEAVE", "Quit" },
            { "SAVE", "Drawing not saved. Save ?" },
            { "SQUARE_SIZE", "Enter size of labyrinth square" },
            { "OPT_MOD", "This modification will be set for the next labyrinth" },
            { "SQUARE_SIZE", "Labyrinth square's size:" },
            { "NEW", "New" },
            { "CURSOR", "Cursor" },
            { "SOLVE", "Solve" },
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
            { "NO_START", "The starting point was not found !" },
            { "NO_END", "The ending point was not found !" },
            { "SAVE_TO_FILE", "Save the labyrinth to a file" },
            { "NOT_SAVED", "The file was not saved" },
            { "IO_ERROR", "An error occurred" },
            { "FILE_NOT_FOUND", "The file was not found" },
            { "ERROR_CHAR_LINE", "Error in the file at line :" },
            { "ERROR_LINE_LEN", "Error with the length of the line :" },
            { "NO_SOLUTION", "No solution found" },
            { "SEGMENT_VALUE", "Value of the segment" },
            { "UPDATE_VALUE", "Actualiser la valeur" },
    };
}