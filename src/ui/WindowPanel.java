package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import ui.Buttons.ButtonsPanel;
import ui.Drawing.DrawingApp;
import ui.Drawing.DrawingPanel;

public class WindowPanel extends JPanel {
	private final DrawingPanel drawingPanel;
	private final ButtonsPanel buttonsPanel;

	public WindowPanel(DrawingApp drawingApp) {
		setLayout(new BorderLayout());

		add(drawingPanel = new DrawingPanel(drawingApp), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(drawingApp), BorderLayout.SOUTH);
	}

	public void notifyForUpdate() {
		drawingPanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
	}
}