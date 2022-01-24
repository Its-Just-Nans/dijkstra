package ui.Buttons;

import javax.swing.JButton;

import ui.Constant;
import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.Elements.Segment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EraseButton extends JButton implements ActionListener {
	private final DrawingApp drawingApp;

	public EraseButton(DrawingApp drawingApp) {
		super("Erase segment"); // Button's text

		this.drawingApp = drawingApp;

		setEnabled(false); // default
		this.setVisible(false);

		addActionListener(this);
	}

	public void notifyForUpdate() {
		String forme = drawingApp.getDrawingAppModel().getCurrentForme();
		String type = drawingApp.getDrawingAppModel().getSelectionType();
		if (forme == Constant.CURSOR) {
			if (type == null) {
				this.setVisible(false);
			} else if (type == Constant.SEGMENT || type == Constant.CERCLE) {
				this.setVisible(true);
				this.setText("Erase " + type);
				setEnabled(true);
			}
		} else {
			this.setVisible(false);
			setEnabled(false);
		}
	}

	public final void actionPerformed(ActionEvent evt) {
		// Operation delegated to the model
		drawingApp.getDrawingAppModel().removeCurrentSelection();
	}
}