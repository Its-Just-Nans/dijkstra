package ui.Buttons;

<<<<<<< HEAD
import javax.swing.*;

import ui.DrawingApp;
import ui.Drawing.*;

import java.awt.*;
import java.awt.event.*;
=======
import javax.swing.JColorChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingAppModel;
import ui.Utils.Constant;
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2

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
		Color newColor = JColorChooser.showDialog(drawingApp, Constant.t("CHANGE_COLOR_SEGMENT"),
				drawingAppModel.getCurrentColor());
		// Changing color triggers refresh
		if (newColor != null) {
			drawingAppModel.setCurrentColor(newColor);
		}
	}
}