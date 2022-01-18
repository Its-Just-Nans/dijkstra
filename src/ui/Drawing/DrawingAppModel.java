package ui.Drawing;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.awt.Color;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import ui.Constant;
import ui.Drawing.Elements.Cercle;
import ui.Drawing.Elements.Segment;

public class DrawingAppModel implements GraphInterface {
    private final ArrayList<Segment> editedSegments = new ArrayList<Segment>();
    private final ArrayList<Cercle> editedCercle = new ArrayList<Cercle>();
    private Color currentColor = new Color(48, 48, 48);

    private Segment currentSegment = null;
    private Segment selectedSegment = null;

    private Cercle currentCercle = null;
    private Cercle selectedCercle = null;

    private String currentForme = null;
    private String selectionType = null; // used with the cursor mode, to know the current figure
    private boolean modified = false;

    public ArrayList<Cercle> getEditedCercle() {
        return this.editedCercle;
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

    public void setCurrentSegment(Segment newCurrent) {
        this.currentSegment = newCurrent;
    }

    public void setCurrentCercle(Cercle newCurrent) {
        this.currentCercle = newCurrent;
    }

    public Segment getSelectedSegment() {
        return this.selectedSegment;
    }

    public void setSelectedSegment(Segment newSelected) {
        this.selectedSegment = newSelected;
        if (newSelected != null) {
            setSelectionType(Constant.SEGMENT);
        }
        stateChanges(); // update the view
    }

    public Cercle getSelectedCercle() {
        return this.selectedCercle;
    }

    public void setSelectedCercle(Cercle newSelected) {
        this.selectedCercle = newSelected;
        if (newSelected != null) {
            setSelectionType(Constant.CERCLE);
        }
        stateChanges(); // update the view
    }

    public final void cancelCurrentSegment() {
        setCurrentSegment(null);
    }

    public final void paintSegments(Graphics g) {
        for (Segment s : editedSegments)
            s.paint(g, false, false);

        if (selectedSegment != null) {
            selectedSegment.paint(g, true, false);
        }

        if (currentSegment != null) {
            currentSegment.paint(g, false, true);
        }
    }

    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

    public void addObserver(ChangeListener listener) {
        listeners.add(listener);
    }

    public void stateChanges() {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(evt);
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
        this.setSelectedCercle(null);
        this.setSelectedSegment(null);
        this.setSelectionType(null);
        stateChanges();
    }

    public final void removeSelectedSegment() {
        if (this.selectedSegment != null) {
            editedSegments.remove(this.selectedSegment);
            setSelectedSegment(null);
        }
    }

    public final void registerCurrentSegment(int x2, int y2) {
        if (this.currentSegment != null) {
            float x1 = (float) currentSegment.getX1();
            float y1 = (float) currentSegment.getY1();
            Cercle end1 = currentSegment.getEnd1();
            float radius = Cercle.getDiametre() / 2;
            for (Cercle oneCercle : this.editedCercle) {
                if (oneCercle != end1) { // le segment ne peut pas avoir deux bouts identiques
                    float xCercle = (float) oneCercle.getRealX();
                    float yCercle = (float) oneCercle.getRealY();
                    float dist = (float) Point2D.distance(x2, y2, xCercle, yCercle);
                    if (dist < radius) {
                        currentSegment.setEnd2(oneCercle);
                        currentSegment.setLine(x1, y1, xCercle, yCercle);
                        editedSegments.add(currentSegment);
                    }
                }
            }
            setCurrentSegment(null);
            stateChanges();
        }
    }

    public final void initCurrentForme(int x, int y) {
        if (this.currentForme == Constant.CERCLE) {
            float diametre = Cercle.getDiametre();
            float realX = x - (diametre / 2); // the x of Ellipse2D is at the top right corner;
            float realY = y - (diametre / 2); // the y of Ellipse2D is at the top right corner;
            editedCercle.add(new Cercle(realX, realY, this.currentColor));
            setCurrentCercle(null);
            setCurrentSegment(null);
            stateChanges();
        } else if (this.currentForme == Constant.SEGMENT) {
            setCurrentCercle(null);
            // check cercle
            Segment newSegment = new Segment(x, y, x, y, this.currentColor);
            float radius = Cercle.getDiametre() / 2;
            for (Cercle oneCercle : this.editedCercle) {
                float xCercle = (float) oneCercle.getRealX();
                float yCercle = (float) oneCercle.getRealY();
                float dist = (float) Point2D.distance(x, y, xCercle, yCercle);
                if (dist < radius) {
                    newSegment.setLine(xCercle, yCercle, x, y);
                    newSegment.setEnd1(oneCercle);
                    setCurrentSegment(newSegment);
                    stateChanges();
                    return;
                }
            }
        }
    }

    public final void modifyCurrentForme(int x2, int y2) {
        if (this.currentSegment != null && this.currentForme == Constant.SEGMENT) {
            float x1 = (float) currentSegment.getX1();
            float y1 = (float) currentSegment.getY1();
            currentSegment.setLine(x1, y1, x2, y2);
        }
        stateChanges();
    }

    public final void cancelCurrentForme() {
        if (this.currentForme == Constant.CERCLE) {
            setCurrentCercle(null);
        } else if (this.currentForme == Constant.SEGMENT) {
            setCurrentSegment(null);
        }
        stateChanges();
    }

    public final void paintCercle(Graphics g) {
        for (Cercle oneCercle : editedCercle) {
            oneCercle.paint(g, false, false);
        }
        if (this.currentCercle != null) {
            this.currentCercle.paint(g, false, true);
        }
        if (this.selectedCercle != null) {
            this.selectedCercle.paint(g, true, false);
        }
    }

    public final void setSelection(int x, int y) {
        double xd = (double) x;
        double yd = (double) y;

        setSelectedCercle(null);
        setSelectedSegment(null);

        for (Cercle oneCercle : editedCercle) {
            float xCercle = oneCercle.getRealX();
            float yCercle = oneCercle.getRealY();
            float radius = Cercle.getDiametre() / 2;
            float dist = (float) Point2D.distance(x, y, xCercle, yCercle);
            if (dist < radius) {
                setSelectedCercle(oneCercle);
                return;
            }
        }

        for (Segment oneSegment : editedSegments) {
            if (oneSegment.ptLineDist(xd, yd) < 2.5) {
                setSelectedSegment(oneSegment);
                return;
            }
        }
    }

    public ArrayList<VertexInterface> getSommets() {
        ArrayList<VertexInterface> toReturn = new ArrayList<VertexInterface>();
        for (Cercle oneCercle : this.editedCercle) {
            toReturn.add((VertexInterface) oneCercle);
        }
        return toReturn;
    }

    public ArrayList<VertexInterface> getSuccessorOf(VertexInterface vertex) {
        ArrayList<VertexInterface> list = new ArrayList<VertexInterface>();
        for (Segment oneSegment : this.editedSegments) {
            if (oneSegment.getEnd1() == vertex) {
                list.add(oneSegment.getEnd2());
            } else if (oneSegment.getEnd2() == vertex) {
                list.add(oneSegment.getEnd1());
            }
        }
        return list;
    }

    public int getWeight(VertexInterface src, VertexInterface dest) {
        Cercle oneCercle = this.searchCercleFromVertex(src);
        // src == oneCercle
        for (Segment oneSegment : this.editedSegments) {
            if (oneSegment.getEnd1() == src) {
                // check End2
                if (oneSegment.getEnd2() == dest) {
                    return oneSegment.getValue();
                }
            } else if (oneSegment.getEnd2() == src) {
                // check End1
                if (oneSegment.getEnd1() == dest) {
                    return oneSegment.getValue();
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private Cercle searchCercleFromVertex(VertexInterface tofind) {
        for (Cercle oneCercle : this.editedCercle) {
            // VertexInterface oneCercleInVertex = (VertexInterface) oneCercle;
            if (oneCercle == tofind) {
                return oneCercle;
            }
        }
        return null;
    }

    public VertexInterface getStart() {
        for (Cercle oneCercle : this.editedCercle) {
            // VertexInterface oneCercleInVertex = (VertexInterface) oneCercle;
            if (oneCercle.getType() == Constant.DEPART) {
                return oneCercle;
            }
        }
        return null;
    }

    public VertexInterface getEnd() {
        for (Cercle oneCercle : this.editedCercle) {
            // VertexInterface oneCercleInVertex = (VertexInterface) oneCercle;
            if (oneCercle.getType() == Constant.ARRIVEE) {
                return oneCercle;
            }
        }
        return null;
    }

    public void setCaseWIN(float x, float y) {
        System.out.println(x + " " + y);
    }
}