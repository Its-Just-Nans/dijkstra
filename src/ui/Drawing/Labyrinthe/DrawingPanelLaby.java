package ui.Drawing.Labyrinthe;

import javax.swing.JPanel;

import ui.Drawing.DrawingApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DrawingPanelLaby extends JPanel {
	private final DrawingApp drawingApp;

	public DrawingPanelLaby(DrawingApp drawingApp) {
		this.drawingApp = drawingApp;

		setBackground(Color.WHITE); // fond du Dessin

		// for pack() instruction
		setPreferredSize(new Dimension(300, 300)); // taille par defaut

		DrawingPanelMouseListenerLaby drawingPanelMouseListenerLaby = new DrawingPanelMouseListenerLaby(drawingApp);

		addMouseListener(drawingPanelMouseListenerLaby);
		addMouseMotionListener(drawingPanelMouseListenerLaby);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Paint the background
		super.paintComponent(g);

		// Ask the model to draw the segments
		drawingApp.getDrawingAppModel().paintSegments(g);
		drawingApp.getDrawingAppModel().paintCercle(g);
	}

	public void notifyForUpdate() {
		repaint();
	}

}