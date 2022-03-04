package ui.Buttons;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.Elements.Segment;
import ui.Utils.Constant;

public class Settings extends JPanel implements ActionListener {
	private final DrawingApp drawingApp;
	private JTextField textField;
	private JLabel label;
	private JButton button;

	public Settings(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp;
		this.setLayout(new GridLayout(3, 1));
		this.add(label = new JLabel(Constant.t("SEGMENT_VALUE")));
		this.add(textField = new JTextField());
		this.add(button = new JButton(Constant.t("UPDATE_VALUE")));
		textField.setText("1");
		button.addActionListener(this);
	}

	public void notifyForUpdate() {
		String curr = drawingApp.getDrawingAppModel().getCurrentForme();
		if (curr.equals(Constant.cst("CURSOR"))) {
			this.setVisible(true);
			String type = drawingApp.getDrawingAppModel().getSelectionType();
			if (type.equals(Constant.cst("SEGMENT"))) {
				Segment s = drawingApp.getDrawingAppModel().getSelectedSegment();
				if (s != null) {
					textField.setText(String.valueOf(s.getValue()));
				}
			}
		} else {
			this.setVisible(false);
		}
	}

	public void changeLocale() {
		label.setText(Constant.t("SEGMENT_VALUE"));
		label.setText(Constant.t("UPDATE_VALUE"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String valueInString = textField.getText();
		int value = 1;
		try {
			if (valueInString != null && !valueInString.equals("")) {
				value = Integer.parseInt(valueInString);
			}
			if (value < 1) {
				value = 1;
			}
			if (value > 400) {
				value = 400;
			}
		} catch (final NumberFormatException ex) {
			value = 1; // rare case when input is void
		}
		String type = drawingApp.getDrawingAppModel().getSelectionType();
		if (type == Constant.cst("SEGMENT")) {
			Segment s = drawingApp.getDrawingAppModel().getSelectedSegment();
			s.setValue(value);
			textField.setText(String.valueOf(value));
		}
	}
}