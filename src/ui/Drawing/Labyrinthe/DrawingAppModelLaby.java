package ui.Drawing.Labyrinthe;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.EBox;
import maze.FBox;
import maze.MBox;
import maze.Maze;
import ui.Drawing.DrawingApp;
import ui.Drawing.Labyrinthe.Elements.Square;
import ui.Utils.Constant;
import ui.Utils.Modal;

public class DrawingAppModelLaby {
    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
    private final ArrayList<Square> editedSquare = new ArrayList<Square>();
    private Color currentColor = new Color(48, 48, 48);
    private boolean clicked = false;
    private int squareSize = 20;
    private int heightLaby = 10;
    private int widthLaby = 10;
    private DrawingApp drawingApp;

    public DrawingAppModelLaby(DrawingApp drawingApp) {
        this.drawingApp = drawingApp;
    }

    public void removeAll() {
        editedSquare.clear();
    }

    public int getHeight() {
        return this.heightLaby;
    }

    public int getWidth() {
        return this.widthLaby;
    }

    public void setDimensions(int newHeight, int newWidth) {
        this.heightLaby = newHeight;
        this.widthLaby = newWidth;
    }

    public boolean getClicked() {
        return this.clicked;
    }

    public void setClicked(boolean newClicked) {
        this.clicked = newClicked;
    }

    public void addSquare(Square sqr) {
        this.editedSquare.add(sqr);
    }

    public int getSquareSize() {
        return this.squareSize;
    }

    public void setSquareSize(int newSize) {
        this.squareSize = newSize;
    }

    public void resetCase(String typeOfReset) {
        for (Square oneSqr : this.editedSquare) {
            String typeOfActualSquare = Constant.convertType(oneSqr.getBoxType());
            if (typeOfActualSquare.equals(typeOfReset)) {
                oneSqr.setBox(new EBox());
            }
        }
    }

    public Color getCurrentColor() {
        return this.currentColor;
    }

    public void initLabyFromFile() {
        this.editedSquare.clear();
        Maze maze = new Maze();
        String pathToFile = Modal.fileChooser();
        if (pathToFile == null) {
            return;
        }
        maze.initFromTextFile(pathToFile);
        List<MBox> listBox = maze.getAllMBox();
        int height = maze.getMaxX();
        int width = maze.getMaxY();
        this.drawingApp.getWindowPanelLaby().setDimensions(height, width);
        this.drawingApp.getWindowPanelLaby().generateLaby(listBox);
    }

    public void addObserver(ChangeListener listener) {
        listeners.add(listener);
    }

    public void stateChanges() {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(evt);
        }
    }

    public final void initCurrentForme(int x, int y) {
        System.out.println("LOOL");
    }

    public final void modifyCurrentForme(int x2, int y2) {
        //
        System.out.println("LOOqsdfkjlhkdjkqdsjL");
        System.out.println("LOOqsdfkjlhkdjkqdsjL");
        this.stateChanges();
    }

    public ArrayList<VertexInterface> getSuccessorOf(VertexInterface vertex) {
        //
        return null;
    }

    public int getWeight(VertexInterface src, VertexInterface dest) {
        //
        return Integer.MAX_VALUE;
    }

    public VertexInterface getStart() {
        //
        return null;
    }

    public VertexInterface getEnd() {
        //
        return null;
    }

    public void setCaseWIN(float x, float y) {
        System.out.println(x + " " + y);
    }

    public void solveDijkstra() {
        ArrayList<ArrayList<MBox>> boxes = new ArrayList<ArrayList<MBox>>();
        for (int hauteur = 0; hauteur < this.heightLaby; hauteur++) {
            ArrayList<MBox> list = new ArrayList<MBox>();
            for (int largeur = 0; largeur < this.widthLaby; largeur++) {
                int positionInList = hauteur * this.widthLaby + largeur;
                MBox temp = editedSquare.get(positionInList).getBox();
                list.add(temp);
            }
            boxes.add(list);
        }

        Maze maze = new Maze(boxes);
        VertexInterface start = maze.findByType("D");
        if (start == null) {
            Modal.makeMessage(Constant.t("NO_START"));
            return;
        }
        MBox end = maze.findByType("A");
        if (end == null) {
            Modal.makeMessage(Constant.t("NO_END"));
            return;
        }
        PreviousInterface chemin = Dijkstra.dijkstra(maze, start);

        ArrayList<MBox> listFinal = new ArrayList<MBox>();
        MBox tempCase = end;
        while (tempCase != null) {
            tempCase = (MBox) chemin.getValue(tempCase);
            if (tempCase == start) {
                break; // don't get the start
            }
            listFinal.add(tempCase); // this line is after to no include the final box
        }
        for (MBox oneBox : listFinal) {
            if (oneBox != null) {
                Square tempSquare = getSquareFormBox(oneBox);
                if (tempSquare != null) {
                    tempSquare.setBox(new FBox());
                }
            }
        }
    }

    private Square getSquareFormBox(MBox box) {
        for (Square oneSquare : editedSquare) {
            if (oneSquare.getBox() == box) {
                return oneSquare;
            }
        }
        return null;
    }
}