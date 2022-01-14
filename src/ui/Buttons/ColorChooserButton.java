package ui.Buttons;

import javax.swing.JColorChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Drawing.DrawingApp;
import ui.Drawing.DrawingAppModel;

public class ColorChooserButton extends JButton implements ActionListener {
	private final DrawingApp drawingApp;

	public ColorChooserButton(DrawingApp drawingApp) {
		super("Choose color"); // Button's text

		this.drawingApp = drawingApp;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		// Used twice
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();

		// Show JColorChooser dialog
		Color newColor = JColorChooser.showDialog(drawingApp, "Change segment color",
				drawingAppModel.getCurrentColor());
		// Changing color triggers refresh
		if (newColor != null) {
			drawingAppModel.setCurrentColor(newColor);
		}
	}
}