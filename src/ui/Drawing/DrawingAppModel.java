package ui.Drawing;

import java.awt.*;
import java.util.*;
import javax.swing.event.*;
import java.awt.geom.Point2D;

public class DrawingAppModel {
    private final ArrayList<Segment> editedSegments = new ArrayList<Segment>();
    private final ArrayList<Cercle> editedCercle = new ArrayList<Cercle>();
    private Color currentColor = new Color(48, 48, 48);

    private Segment currentSegment = null;
    private Segment selectedSegment = null;

    private Cercle currentCercle = null;
    private Cercle selectedCercle = null;

    private String currentForme = null;

    private boolean modified = false;

    public Color getCurrentColor() {
        return this.currentColor;
    }

    public String getCurrentForme() {
        return this.currentForme;
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
        System.out.println(x + " " + y);
        if (this.currentForme == "Cercle") {
            float diametre = Cercle.getDiametre();
            float realX = x - (diametre / 2); // the x of Ellipse2D is at the top right corner;
            float realY = y - (diametre / 2); // the y of Ellipse2D is at the top right corner;
            editedCercle.add(new Cercle(realX, realY, this.currentColor));
            System.out.println(realX + " " + realY);
            setCurrentCercle(null);
            setCurrentSegment(null);
            stateChanges();
        } else if (this.currentForme == "Segment") {
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
        System.out.println(x2 + " " + y2);
        if (this.currentSegment != null && this.currentForme == "Segment") {
            float x1 = (float) currentSegment.getX1();
            float y1 = (float) currentSegment.getY1();
            currentSegment.setLine(x1, y1, x2, y2);
        }
        stateChanges();
    }

    public final void cancelCurrentForme() {
        if (this.currentForme == "Cercle") {
            setCurrentCercle(null);
        } else if (this.currentForme == "Segment") {
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
    }

    public final void setSelection(int x, int y) {
        double xd = (double) x;
        double yd = (double) y;

        for (Segment oneSegement : editedSegments) {
            if (oneSegement.ptLineDist(xd, yd) < 2.5) {
                setSelectedSegment(oneSegement);
                stateChanges();
                return;
            }
        }

        setSelectedSegment(null);
    }
}