package ui.Buttons;

import java.awt.GridLayout;
import javax.swing.JPanel;

import ui.Drawing.DrawingApp;

public class ButtonsPanel extends JPanel {
	private final ListFormes listFormes;
	private final ButtonsOptions buttonsOptions;

	public ButtonsPanel(DrawingApp drawingApp) {
		super();

		setLayout(new GridLayout(1, 2)); // 1 row, 4 columns
		add(listFormes = new ListFormes(drawingApp));
		add(buttonsOptions = new ButtonsOptions(drawingApp));
	}

	public void notifyForUpdate() {
		listFormes.notifyForUpdate();
		buttonsOptions.notifyForUpdate();
	}

	public void changeLocale() {
		listFormes.changeLocale();
		buttonsOptions.changeLocale();
	}
}