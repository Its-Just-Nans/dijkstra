package ui.Drawing.Labyrinthe;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import ui.Buttons.ButtonsPanel;
import ui.Buttons.ButtonsOptions;
import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingPanel;

public class WindowPanelLaby extends JPanel {
	private final DrawingPanelLaby drawingPanelLaby;
	// private final ButtonsPanel buttonsPanel;
	// private final ButtonsOptions buttonsOptions;

	public WindowPanelLaby(DrawingApp drawingApp) {
		this.setLayout(new BorderLayout());

		this.drawingPanelLaby = new DrawingPanelLaby(drawingApp);
		this.add(drawingPanelLaby, BorderLayout.CENTER);
	}

	public void notifyForUpdate() {
		drawingPanelLaby.notifyForUpdate();
		// drawingPanel.notifyForUpdate();
		// buttonsPanel.notifyForUpdate();
		// buttonsOptions.notifyForUpdate();
	}
}