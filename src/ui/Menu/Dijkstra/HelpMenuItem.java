package ui.Menu.Dijkstra;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;
import ui.Utils.Modal;

public class HelpMenuItem extends JMenuItem implements ActionListener {
   public HelpMenuItem(DrawingApp drawingApp) {
      super(Constant.t("HELP")); // Text of menu item
      addActionListener(this);
   }

   /**
    * @param evt
    */
   public void actionPerformed(ActionEvent evt) {
      Modal.makeMessage(Constant.t("HELP_DIJKSTRA"));
   }

   public void changeLocale() {
      this.setText(Constant.t("HELP"));
   }
}