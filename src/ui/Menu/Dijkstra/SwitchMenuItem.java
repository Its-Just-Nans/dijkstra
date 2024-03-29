package ui.Menu.Dijkstra;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class SwitchMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public SwitchMenuItem(DrawingApp drawingApp) {
      super(Constant.t("SWITCH")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   /**
    * @param evt
    */
   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.changeTo(Constant.cst("GRAPH"), false);
   }

   public void changeLocale() {
      this.setText(Constant.t("SWITCH"));
   }
}