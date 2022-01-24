package ui.Drawing.Labyrinthe.Elements;

import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import dijkstra.VertexInterface;
import ui.Constant;

public class Square extends Rectangle2D.Float implements VertexInterface {
    private Color color = Color.BLACK;
    private String type;
    private final static float defaultWidth = 20f;

    public Square(float x1, float y1, Color color) {
        super(x1, y1, defaultWidth, defaultWidth);

        this.color = color;
        setType(Constant.NORMAL);
    }

    private final static BasicStroke basicStroke = new BasicStroke();

    public static float getDefaultWidth() {
        return defaultWidth;
    }

    public String getLabel() {
        return this.type;
    }

    public void setType(String newType) {
        this.type = newType;
        if (this.type == Constant.NORMAL) {
            this.color = Color.BLACK;
        } else if (this.type == Constant.DEPART) {
            this.color = Color.BLUE;
        } else if (this.type == Constant.ARRIVEE) {
            this.color = Color.RED;
        }
    }

    public String getType() {
        return this.type;
    }

    public float getRealX() {
        return x + (width / 2); // the x of Ellipse2D is at the top right corner;
    }

    public float getRealY() {
        return y + (width / 2); // the y of Ellipse2D is at the top right corner;
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
        g2.fill(this);
        g2.draw(this);
    }
}