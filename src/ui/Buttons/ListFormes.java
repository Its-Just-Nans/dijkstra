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
import ui.Utils.Constant;

public class ListFormes extends JPanel implements ItemListener {
	private final DrawingApp drawingApp;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public ListFormes(DrawingApp drawingApp) {
		super();
		this.setLayout(new GridLayout(3, 1));

		this.drawingApp = drawingApp;

		ArrayList<JRadioButton> listButtons = new ArrayList<JRadioButton>();
		listButtons.add(new JRadioButton(Constant.t("CURSOR")));
		listButtons.add(new JRadioButton(Constant.t("SEGMENT")));
		listButtons.add(new JRadioButton(Constant.t("CERCLE")));

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