package ui.Drawing.Labyrinthe;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import ui.Constant;
import ui.Drawing.Labyrinthe.Elements.Square;

public class DrawingAppModelLaby implements GraphInterface {
    private final ArrayList<ArrayList<Square>> editedSquare = new ArrayList<ArrayList<Square>>();
    private Color currentColor = new Color(48, 48, 48);

    private Square currentSquare = null;
    private Square selectedSquare = null;

    private String currentForme = null;
    private String selectionType = null; // used with the cursor mode, to know the current figure
    private boolean modified = false;

    public ArrayList<VertexInterface> getEditedCercle() {
        ArrayList<VertexInterface> allSquare = new ArrayList<VertexInterface>();
        int width = this.editedSquare.size();
        int height = this.editedSquare.get(0).size();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                allSquare.add(this.editedSquare.get(i).get(j));
            }
        }
        return allSquare;
    }

    public Color getCurrentColor() {
        return this.currentColor;
    }

    public String getCurrentForme() {
        return this.currentForme;
    }

    public String getSelectionType() {
        return this.selectionType;
    }

    public void setSelectionType(String select) {
        this.selectionType = select;
    }

    public boolean isModified() {
        return this.modified;
    }

    public void saveToFile() {
        System.out.println("SAVE TO FILE");
    }

    public void setCurrentSquare(Square newCurrent) {
        this.currentSquare = newCurrent;
    }

    public Square getSelectedSquare() {
        return this.selectedSquare;
    }

    public void setSelectedSquare(Square newSelected) {
        this.selectedSquare = newSelected;
        if (newSelected != null) {
            setSelectionType(Constant.SEGMENT);
        }
        stateChanges(); // update the view
    }

    public final void cancelCurrentSquare() {
        setCurrentSquare(null);
    }

    public final void paintSquares(Graphics g) {
        // ArrayList<Square> list = this.getEditedCercle();
        // for (Square s : list) {
        // s.paint(g, false, false);
        // }

        if (selectedSquare != null) {
            selectedSquare.paint(g, true, false);
        }

        if (currentSquare != null) {
            currentSquare.paint(g, false, true);
        }
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

    public final void setCurrentColor(Color currentColor) {
        if (this.currentColor != currentColor) {
            this.currentColor = currentColor;
            modified = true;
            stateChanges();
        }
    }

    public final void setCurrentForme(String newCurrentForme) {
        this.currentForme = newCurrentForme;
        this.setSelectedSquare(null);
        this.setSelectionType(null);
        stateChanges();
    }

    public final void removeCurrentSelection() {
        if (this.selectionType != null) {
            if (this.selectionType == Constant.SEGMENT) {
                editedSquare.remove(this.selectedSquare);
                setSelectedSquare(null);
            }
        }
        this.setSelectionType(null);
        this.stateChanges(); // notify to hide the erase button
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

    public final void cancelCurrentForme() {
        setCurrentSquare(null);
        this.stateChanges();
    }

    public final void setSelection(int x, int y) {
        System.out.println("LOOqsdfkqsdgmljfdlsgjlkdsfgjlsdkgjlmksdfjglkjdfkjlhkdjkqdsjL");
        setSelectedSquare(null);
        this.setSelectionType(null);
        this.stateChanges(); // update for unselect, when click on background
    }

    public ArrayList<VertexInterface> getSommets() {
        return this.getEditedCercle();
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