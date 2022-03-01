package ui.Drawing;

import java.awt.*;
import java.awt.geom.*;

public class Cercle extends Ellipse2D.Float {
    private Color color = Color.BLACK;

    private final static float diametre = 20f;

    public Cercle(float x1, float y1, Color color) {
        super(x1, y1, diametre, diametre);

        this.color = color;
    }

    private final static float[] dash = { 4.0f };

    private final static BasicStroke usualStroke;
    private final static BasicStroke largeStroke;
    private final static BasicStroke dashStroke;

    static { // Static initialization of drawing modes
        usualStroke = new BasicStroke(3.0f);
        largeStroke = new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        dashStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
    }

    public static float getDiametre() {
        return diametre;
    }

    public float getRealX() {
        return x + (diametre / 2); // the x of Ellipse2D is at the top right corner;
    }

    public float getRealY() {
        return y + (diametre / 2); // the y of Ellipse2D is at the top right corner;
    }

    public final void paint(Graphics g, boolean selected, boolean current) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(color);

        if (current) {
            g2.setStroke(dashStroke); // Dashed lines mode
            g2.draw(this);
            g2.setStroke(usualStroke); // Normal mode
        } else if (selected) {
            g2.setStroke(largeStroke); // Large lines mode
            g2.draw(this);
            g2.setStroke(usualStroke); // Normal mode
        } else {
            g2.draw(this);
        }
        g2.fill(this);
    }
}