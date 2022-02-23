package ui.Drawing.Dijkstra.Elements;

import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import dijkstra.VertexInterface;
import ui.Utils.Constant;

public class Cercle extends Ellipse2D.Float implements VertexInterface {
    private Color color = Color.BLACK;
    private String type;
    private final static float diametre = 20f;

    public Cercle(float x1, float y1, Color color) {
        super(x1, y1, diametre, diametre);

        this.color = color;
        setType(Constant.cst("NORMAL"));
    }

    private final static BasicStroke basicStroke = new BasicStroke();

    public static float getDiametre() {
        return diametre;
    }

    public String getLabel() {
        return this.type;
    }

    public void setType(String newType) {
        this.type = newType;
        if (this.type.equals(Constant.cst("NORMAL"))) {
            this.color = Color.BLACK;
        } else if (this.type.equals(Constant.cst("START"))) {
            this.color = Color.BLUE;
        } else if (this.type.equals(Constant.cst("END"))) {
            this.color = Color.RED;
        }
    }

    public String getType() {
        return this.type;
    }

    public float getRealX() {
        return x + (diametre / 2); // the x of Ellipse2D is at the top right corner;
    }

    public float getRealY() {
        return y + (diametre / 2); // the y of Ellipse2D is at the top right corner;
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