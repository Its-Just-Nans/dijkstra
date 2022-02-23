package ui.Drawing.Labyrinthe;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;

import ui.Drawing.DrawingApp;
import ui.Drawing.Labyrinthe.Elements.Square;
import ui.Utils.Constant;

public class WindowPanelLaby extends JPanel {
	private final DrawingApp drawingApp;
	private DrawingAppModelLaby drawingAppModelLaby;
	private int height;

	public WindowPanelLaby(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp;
		drawingAppModelLaby = drawingApp.getDrawingAppModelLaby();
		this.height = 10;
		setLayout(new GridLayout(this.height, this.height));
		this.generateLaby();
		this.setBackground(Color.RED);
	}

	public void setTheHeight(int newHeight) {
		this.height = newHeight;
		setLayout(new GridLayout(this.height, this.height));
		this.generateLaby();
	}

	public int getTheHeight() {
		return height;
	}

	public void generateLaby() {
		this.removeAll();
		int totalNumber = this.height * this.height;
		for (int i = 0; i < totalNumber; i++) {
			Square square = new Square(this.drawingApp, Constant.cst("NORMAL"));
			DrawingPanelMouseListenerLaby drawingPanelMouseListenerLaby = new DrawingPanelMouseListenerLaby(
					this.drawingApp,
					square);
			square.addMouseListener(drawingPanelMouseListenerLaby);
			// square.setBorder(BorderFactory.createLineBorder(Color.black));
			drawingAppModelLaby.addSquare(square);
			this.add(square);
		}
	}

	public void notifyForUpdate() {

	}

}