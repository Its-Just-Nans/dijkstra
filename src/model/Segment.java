package model;

import java.awt.*;
import java.awt.geom.*;

public class Segment extends Line2D.Float {
    private Color color = Color.BLACK;

    public Segment(float x1, float y1,
            float x2, float y2, Color color) {
        super(x1, y1, x2, y2);

        this.color = color;
    }

    private final static float[] dash = { 4.0f };

    private final static BasicStroke usualStroke;
    private final static BasicStroke largeStroke;
    private final static BasicStroke dashStroke;

    static { // Static initialization of drawing modes
        usualStroke = new BasicStroke();
        largeStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        dashStroke = new BasicStroke(1.0f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
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
    }
}