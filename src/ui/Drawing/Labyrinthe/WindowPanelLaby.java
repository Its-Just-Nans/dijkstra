package ui.Drawing.Labyrinthe;

import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import ui.Buttons.ButtonsPanel;
import ui.Constant;
import ui.Buttons.ButtonsOptions;
import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingPanel;
import ui.Drawing.Labyrinthe.Elements.Square;

public class WindowPanelLaby extends JPanel {
	private final DrawingApp drawingApp;
	private ArrayList<Square> listSquare;
	private DrawingAppModelLaby drawingAppModelLaby;
	private int height;

	public WindowPanelLaby(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp;
		drawingAppModelLaby = drawingApp.getDrawingAppModelLaby();
		this.listSquare = new ArrayList<Square>();
		this.height = 5;
		setLayout(new GridLayout(this.height, this.height));

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
			Square square = new Square(this.drawingApp, Constant.NORMAL);
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