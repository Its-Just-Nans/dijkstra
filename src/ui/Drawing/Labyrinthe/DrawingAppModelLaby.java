package ui.Drawing.Labyrinthe;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import maze.Maze;
import ui.Constant;
import ui.Drawing.Labyrinthe.Elements.Square;

public class DrawingAppModelLaby extends Maze {
    private final ArrayList<Square> editedSquare = new ArrayList<Square>();
    private Color currentColor = new Color(48, 48, 48);
    private boolean clicked = false;
    private int squareSize = 20;

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
            String typeOfActualSquare = oneSqr.getType();
            if (typeOfActualSquare.equals(typeOfReset)) {
                oneSqr.changeColor(Color.WHITE);
            }
        }
    }

    public Color getCurrentColor() {
        return this.currentColor;
    }

    @Override
    public List<VertexInterface> getSommets() {
        List<VertexInterface> list = new ArrayList<VertexInterface>();
        for (Square oneSquare : this.editedSquare) {
            list.add(oneSquare);
        }
        return list;
    }

    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

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

    private Square searchCercleFromVertex(VertexInterface tofind) {
        //
        return null;
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
}