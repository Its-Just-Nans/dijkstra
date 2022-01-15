package ui.Buttons;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import ui.Drawing.DrawingApp;
import ui.Drawing.Elements.Cercle;

public class ListType extends JPanel implements ItemListener {
	private final DrawingApp drawingApp;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<JRadioButton> listButtons = new ArrayList<JRadioButton>();

	public ListType(DrawingApp drawingApp) {
		super();
		this.setLayout(new GridLayout(3, 1));
		this.setVisible(false);
		this.drawingApp = drawingApp;

		listButtons.add(new JRadioButton("Normal"));
		listButtons.add(new JRadioButton("Arrivée"));
		listButtons.add(new JRadioButton("Depart"));
		listButtons.add(new JRadioButton("Mur"));

		listButtons.get(0).setSelected(true);// default is normal

		for (JRadioButton oneButton : listButtons) {
			buttonGroup.add(oneButton); // add to the group
			this.add(oneButton); // add to the panel
			oneButton.addItemListener(this);
		}
	}

	public void notifyForUpdate() {
		if (drawingApp.getDrawingAppModel().getCurrentForme() == "Cursor") {
			String forme = drawingApp.getDrawingAppModel().getSelectionType();
			if (forme == "Cercle") {
				this.setVisible(true);
				changeSeletedType();
			} else {
				this.setVisible(false);
			}
		} else {
			this.setVisible(false);
		}
	}

	private void changeSeletedType() {
		Cercle cercle = drawingApp.getDrawingAppModel().getSelectedCercle();
		if (cercle != null) {
			String type = cercle.getType();
			for (JRadioButton oneButton : listButtons) {
				oneButton.setSelected(false);
				String actualType = oneButton.getText();
				if (type == actualType) {
					oneButton.setSelected(true);
				}
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// Operation delegated to the model
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		for (/* already init */; buttons.hasMoreElements(); /* no need */) {
			AbstractButton oneButton = buttons.nextElement();

			if (oneButton.isSelected()) {
				String type = oneButton.getText();
				Cercle cercle = this.drawingApp.getDrawingAppModel().getSelectedCercle();
				cercle.setType(type);
				this.drawingApp.getDrawingAppModel().setSelectedCercle(cercle);
				return;
			}
		}
	}
}