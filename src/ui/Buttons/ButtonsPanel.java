package ui.Buttons;

import java.awt.GridLayout;
import javax.swing.JPanel;

import ui.Drawing.DrawingApp;

public class ButtonsPanel extends JPanel {
	private final ColorIndicator colorIndicator;
	private final ColorChooserButton colorChooser;
	private final EraseSegmentButton eraseSegment;
	private final ListFormes ListFormes;

	public ButtonsPanel(DrawingApp drawingApp) {
		super();
		setLayout(new GridLayout(1, 4)); // 1 row, 4 columns

		add(colorIndicator = new ColorIndicator(drawingApp));
		add(colorChooser = new ColorChooserButton(drawingApp));
		add(eraseSegment = new EraseSegmentButton(drawingApp));
		add(ListFormes = new ListFormes(drawingApp));
	}

	public void notifyForUpdate() {
		colorIndicator.notifyForUpdate();
		eraseSegment.notifyForUpdate();
	}
}