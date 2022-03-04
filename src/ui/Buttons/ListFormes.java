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
import ui.Drawing.Dijkstra.Elements.Cercle;
import ui.Utils.Constant;

public class ListFormes extends JPanel implements ItemListener {
	private final DrawingApp drawingApp;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton CURSORbutton;
	private final JRadioButton SEGMENTbutton;
	private final JRadioButton CERCLEbutton;

	public ListFormes(DrawingApp drawingApp) {
		super();
		this.setLayout(new GridLayout(3, 1));

		this.drawingApp = drawingApp;

		ArrayList<JRadioButton> listButtons = new ArrayList<JRadioButton>();
		listButtons.add(CURSORbutton = new JRadioButton(Constant.t("CURSOR")));
		listButtons.add(SEGMENTbutton = new JRadioButton(Constant.t("SEGMENT")));
		listButtons.add(CERCLEbutton = new JRadioButton(Constant.t("CERCLE")));

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
				String type = "";
				if (oneButton == CURSORbutton) {
					type = Constant.cst("CURSOR");
				} else if (oneButton == SEGMENTbutton) {
					type = Constant.cst("SEGMENT");
				} else if (oneButton == CERCLEbutton) {
					type = Constant.cst("CERCLE");
				}
				this.drawingApp.getDrawingAppModel().setCurrentForme(type);
				return;
			}
		}
	}

	public void changeLocale() {
		CURSORbutton.setText(Constant.t("CURSOR"));
		SEGMENTbutton.setText(Constant.t("SEGMENT"));
		CERCLEbutton.setText(Constant.t("CERCLE"));
	}

	public void notifyForUpdate() {

	}
}