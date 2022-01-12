package model;

import java.awt.*;
import java.util.*;
import javax.swing.event.*;

public class DrawingAppModel {
    private final ArrayList<Segment> editedSegments = new ArrayList<Segment>(128);
    private Color currentColor = new Color(48, 48, 48);
    private Segment currentSegment = null;
    private Segment selectedSegment = null;
    private boolean modified = false;

    public Color getCurrentColor() {
        return this.currentColor;
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

    public Segment getSelectedSegment() {
        return this.selectedSegment;
    }

    public void setSelectedSegment(Segment newSelected) {
        this.selectedSegment = newSelected;
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

    public final void removeSelectedSegment() {
        if (this.selectedSegment != null) {
            editedSegments.remove(this.selectedSegment);
            this.selectedSegment = null;
            stateChanges();
        }
    }

    public final void initCurrentSegment(int x, int y) {
        setCurrentSegment(new Segment(x, y, x, y, currentColor));
    }

    public final void modifyCurrentSegment(int x2, int y2) {
        if (this.currentSegment != null) {
            float x1 = (float) currentSegment.getX1();
            float y1 = (float) currentSegment.getY1();
            setCurrentSegment(new Segment(x1, y1, x2, y2, currentColor));
        }
    }

    public final void registerCurrentSegment(int x2, int y2) {
        if (this.currentSegment != null) {
            float x1 = (float) currentSegment.getX1();
            float y1 = (float) currentSegment.getY1();
            if (Math.abs(x1 - (float) x2) >= 1.0f || Math.abs(y1 - (float) y2) >= 1.0f) {
                currentSegment = null;
                editedSegments.add(new Segment(x1, y1, x2, y2, currentColor));
                stateChanges();
            }
        }
    }

    public final void setSelection(int x, int y) {
        double xd = (double) x;
        double yd = (double) y;

        for (Segment oneSegement : editedSegments) {
            if (oneSegement.ptLineDist(xd, yd) < 1.0) {
                setSelectedSegment(oneSegement);
                return;
            }
        }

        setSelectedSegment(null);
    }
}