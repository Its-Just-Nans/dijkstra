package ui.Buttons;

import javax.swing.*;
import java.awt.*;

import ui.DrawingApp;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class ListFormes extends JPanel implements ItemListener {
	private final DrawingApp drawingApp;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public ListFormes(DrawingApp drawingApp) {
		super();
		this.setLayout(new GridLayout(3, 1));

		this.drawingApp = drawingApp;

		ArrayList<JRadioButton> listButtons = new ArrayList<JRadioButton>();
		listButtons.add(new JRadioButton("Cursor"));
		listButtons.add(new JRadioButton("Segment"));
		listButtons.add(new JRadioButton("Cercle"));

		listButtons.get(0).setSelected(true); // default is cursor

		for (JRadioButton oneButton : listButtons) {
			buttonGroup.add(oneButton); // add to the group
			this.add(oneButton); // add to the panel
			oneButton.addItemListener(this);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// Operation delegated to the model
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		for (/* already init */; buttons.hasMoreElements(); /* no need */) {
			AbstractButton oneButton = buttons.nextElement();

			if (oneButton.isSelected()) {
				String type = oneButton.getText();
				this.drawingApp.getDrawingAppModel().setCurrentForme(type);
				return;
			}
		}
	}
}