package ui.Drawing.Dijkstra;

import javax.swing.JPanel;

import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingPanelMouseListenerDijkstra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DrawingPanel extends JPanel {
	private final DrawingApp drawingApp;

	public DrawingPanel(DrawingApp drawingApp) {
		this.drawingApp = drawingApp;

		this.setBackground(Color.WHITE); // fond du Dessin

		// for pack() instruction
		this.setPreferredSize(new Dimension(300, 300)); // taille par defaut

		DrawingPanelMouseListenerDijkstra drawingPanelMouseListenerDijkstra = new DrawingPanelMouseListenerDijkstra(
				drawingApp);

		this.addMouseListener(drawingPanelMouseListenerDijkstra);
		this.addMouseMotionListener(drawingPanelMouseListenerDijkstra);
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