package ui.Buttons;

import javax.swing.JButton;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EraseButton extends JButton implements ActionListener {
	private final DrawingApp drawingApp;

	public EraseButton(DrawingApp drawingApp) {
		super(Constant.t("DEL_SEG")); // Button's text
		this.drawingApp = drawingApp;

		setEnabled(false); // default
		this.setVisible(false);

		addActionListener(this);
	}

	public void notifyForUpdate() {
		String forme = drawingApp.getDrawingAppModel().getCurrentForme();
		String type = drawingApp.getDrawingAppModel().getSelectionType();
		if (forme.equals(Constant.cst("CURSOR"))) {
			if (type == "") {
				this.setVisible(false);
			} else if (type.equals(Constant.cst("SEGMENT")) || type.equals(Constant.cst("CERCLE"))) {
				this.changeLocale();
				this.setVisible(true);
				setEnabled(true);
			}
		} else {
			this.setVisible(false);
			setEnabled(false);
		}
	}

	/**
	 * @param evt
	 */
	public final void actionPerformed(ActionEvent evt) {
		// Operation delegated to the model
		drawingApp.getDrawingAppModel().removeCurrentSelection();
	}

	public final void changeLocale() {
		String type = drawingApp.getDrawingAppModel().getSelectionType();
		if (type.equals(Constant.cst("SEGMENT"))) {
			this.setText(Constant.t("DEL_SEG"));
		} else {
			this.setText(Constant.t("DEL_CIRCLE"));
		}
	}
}