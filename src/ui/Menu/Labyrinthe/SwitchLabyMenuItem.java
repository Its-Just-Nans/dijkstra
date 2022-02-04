package ui.Menu.Labyrinthe;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class SwitchLabyMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public SwitchLabyMenuItem(DrawingApp drawingApp) {
      super(Constant.t("SWITCH")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.changeTo(Constant.t("LABY"));
   }

   public void changeLocale() {
      this.setText(Constant.t("SWITCH"));
   }
}