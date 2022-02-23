package ui.Drawing.Dijkstra;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import ui.Buttons.ButtonsPanel;
import ui.Buttons.ButtonsOptions;
import ui.Drawing.DrawingApp;

public class WindowPanel extends JPanel {
	private final DrawingPanel drawingPanel;
	private final ButtonsPanel buttonsPanel;
	private final ButtonsOptions buttonsOptions;

	public WindowPanel(DrawingApp drawingApp) {
		setLayout(new BorderLayout());

		this.drawingPanel = new DrawingPanel(drawingApp);
		add(drawingPanel, BorderLayout.CENTER);

		add(buttonsPanel = new ButtonsPanel(drawingApp), BorderLayout.SOUTH);
		add(buttonsOptions = new ButtonsOptions(drawingApp), BorderLayout.EAST);
	}

	public void notifyForUpdate() {
		drawingPanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
		buttonsOptions.notifyForUpdate();
	}

	public void changeLocale() {
		drawingPanel.changeLocale();
		buttonsPanel.changeLocale();
		buttonsOptions.changeLocale();
	}
}