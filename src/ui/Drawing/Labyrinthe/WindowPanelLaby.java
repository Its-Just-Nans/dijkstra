package ui.Drawing.Labyrinthe;

import java.awt.GridLayout;
import java.util.List;
import java.awt.Color;
import javax.swing.JPanel;

import maze.EBox;
import maze.MBox;
import ui.Drawing.DrawingApp;
import ui.Drawing.Labyrinthe.Elements.Square;

public class WindowPanelLaby extends JPanel {
	private final DrawingApp drawingApp;
	private DrawingAppModelLaby drawingAppModelLaby;

	public WindowPanelLaby(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp;
		drawingAppModelLaby = drawingApp.getDrawingAppModelLaby();
		int height = drawingAppModelLaby.getHeight();
		int width = drawingAppModelLaby.getWidth();
		setLayout(new GridLayout(height, width));
		this.generateLaby(height, width);
		this.setBackground(Color.RED);
	}

	public void setDimensions(int newHeight, int newWidth) {
		drawingAppModelLaby.setDimensions(newHeight, newWidth);
		this.setLayout(new GridLayout(newHeight, newWidth));
	}

	public void generateLaby(int height, int width) {
		this.removeAll();
		this.drawingAppModelLaby.removeAll();
		int totalNumber = height * width;
		for (int i = 0; i < totalNumber; i++) {
			Square square = new Square(this.drawingApp, new EBox());
			int coordX = i % width;
			int coordY = i / width;
			square.setCoord(coordX, coordY);
			DrawingPanelMouseListenerLaby drawingPanelMouseListenerLaby = new DrawingPanelMouseListenerLaby(
					this.drawingApp,
					square);
			square.addMouseListener(drawingPanelMouseListenerLaby);
			// square.setBorder(BorderFactory.createLineBorder(Color.black));
			this.drawingAppModelLaby.addSquare(square);

			this.add(square);
		}
	}

	public void generateLaby(List<MBox> list) {
		this.removeAll();
		int count = 0;
		int height = drawingAppModelLaby.getHeight();
		int width = drawingAppModelLaby.getWidth();
		for (MBox oneVertex : list) {
			Square square = new Square(this.drawingApp, oneVertex);
			int coordX = count % width;
			int coordY = count / width;
			square.setCoord(coordX, coordY);
			DrawingPanelMouseListenerLaby drawingPanelMouseListenerLaby = new DrawingPanelMouseListenerLaby(
					this.drawingApp,
					square);
			square.addMouseListener(drawingPanelMouseListenerLaby);
			// square.setBorder(BorderFactory.createLineBorder(Color.black));
			drawingAppModelLaby.addSquare(square);

			this.add(square);
			count++;
		}
		drawingApp.pack();
	}

	public void notifyForUpdate() {

	}

}