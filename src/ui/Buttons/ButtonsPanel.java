package ui.Buttons;

<<<<<<< HEAD
import java.awt.*;
import javax.swing.*;

import ui.ColorIndicator;
import ui.DrawingApp;

public class ButtonsPanel extends JPanel {
	private final ColorIndicator colorIndicator;
	private final ColorChooserButton colorChooser;
	private final EraseSegmentButton eraseSegment;
=======
import java.awt.GridLayout;
import javax.swing.JPanel;

import ui.Drawing.DrawingApp;

public class ButtonsPanel extends JPanel {
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2
	private final ListFormes ListFormes;

	public ButtonsPanel(DrawingApp drawingApp) {
		super();
<<<<<<< HEAD
		setLayout(new GridLayout(1, 4)); // 1 row, 3 columns

		add(colorIndicator = new ColorIndicator(drawingApp));
		add(colorChooser = new ColorChooserButton(drawingApp));
		add(eraseSegment = new EraseSegmentButton(drawingApp));
=======
		setLayout(new GridLayout(1, 1)); // 1 row, 4 columns

>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2
		add(ListFormes = new ListFormes(drawingApp));
	}

	public void notifyForUpdate() {
<<<<<<< HEAD
		colorIndicator.notifyForUpdate();
		eraseSegment.notifyForUpdate();
=======
		// do nothing
	}

	public void changeLocale() {
		ListFormes.changeLocale();
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2
	}
}