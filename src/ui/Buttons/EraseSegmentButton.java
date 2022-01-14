package ui.Buttons;

import javax.swing.JButton;
import ui.Drawing.DrawingApp;
import ui.Drawing.Elements.Segment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EraseSegmentButton extends JButton implements ActionListener {
	private final DrawingApp drawingApp;

	public EraseSegmentButton(DrawingApp drawingApp) {
		super("Erase segment"); // Button's text

		this.drawingApp = drawingApp;

		setEnabled(false); // default
		addActionListener(this);
	}

	public void notifyForUpdate() {
		Segment selected = drawingApp.getDrawingAppModel().getSelectedSegment();

		setEnabled(selected != null);
	}

	public final void actionPerformed(ActionEvent evt) {
		// Operation delegated to the model
		drawingApp.getDrawingAppModel().removeSelectedSegment();
	}
}