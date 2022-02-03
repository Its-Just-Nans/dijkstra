package ui.Drawing.Labyrinthe.Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import dijkstra.VertexInterface;
import ui.Constant;
import ui.Drawing.DrawingApp;

public class Square extends JPanel implements VertexInterface {
    private Color color = Color.BLACK;
    private String type;
    private int width;
    private DrawingApp drawingApp;
    private final static BasicStroke basicStroke = new BasicStroke();

    public Square(DrawingApp drawingApp, String newtype) {
        super();
        this.drawingApp = drawingApp;
        int cubeSize = this.drawingApp.getDrawingAppModelLaby().getSquareSize();
        this.setPreferredSize(new Dimension(cubeSize, cubeSize));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setType(newtype);
    }

    public Square(int x1, int y1, int newWidth, Color color) {
        super();
        this.width = newWidth;

        setType(Constant.NORMAL);
    }

    public void changeColor(Color newColor) {
        if (newColor == null) {
            if (Color.WHITE.equals(this.color)) {
                this.setType(Constant.MUR);
            } else if (Color.BLACK.equals(this.color)) {
                this.setType(Constant.DEPART);
            } else if (Color.BLUE.equals(this.color)) {
                this.setType(Constant.ARRIVEE);
            } else if (Color.RED.equals(this.color)) {
                this.setType(Constant.NORMAL);
            }
        } else {
            this.color = newColor;
        }
        this.setBackground(this.color);
    }

    public String getLabel() {
        return this.type;
    }

    public void setType(String newType) {
        this.type = newType;
        if (this.type == Constant.NORMAL) {
            this.color = Color.WHITE;
        } else if (this.type == Constant.DEPART) {
            this.drawingApp.getDrawingAppModelLaby().resetCase(Constant.DEPART);
            this.color = Color.BLUE;
        } else if (this.type == Constant.ARRIVEE) {
            this.drawingApp.getDrawingAppModelLaby().resetCase(Constant.ARRIVEE);
            this.color = Color.RED;
        } else if (this.type == Constant.MUR) {
            this.color = Color.BLACK;
        }
    }

    public String getType() {
        return this.type;
    }

    public final void paint(Graphics g, boolean selected, boolean current) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(basicStroke);
        g2.setColor(color);
        if (selected) {
            if (this.color == Color.BLACK) {
                g2.setColor(Color.GRAY);
            } else {
                Color customColor = this.color;
                g2.setColor(customColor.darker()); // darker to see selection
            }
        }
        // g2.fill(this);
        // g2.draw(this);
    }
}