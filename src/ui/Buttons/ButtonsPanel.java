package ui.Buttons;

import java.awt.GridLayout;
import javax.swing.JPanel;

import ui.Drawing.DrawingApp;

public class ButtonsPanel extends JPanel {
	private final ListFormes ListFormes;

	public ButtonsPanel(DrawingApp drawingApp) {
		super();

		setLayout(new GridLayout(1, 1)); // 1 row, 4 columns
		add(ListFormes = new ListFormes(drawingApp));
	}

	public void notifyForUpdate() {
		// do nothing
	}

	public void changeLocale() {
		ListFormes.changeLocale();
	}
}