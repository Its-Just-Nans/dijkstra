package ui.Menu.Dijkstra;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class NewMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public NewMenuItem(DrawingApp drawingApp) {
      super(Constant.t("NEW")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.newGame(Constant.cst("GRAPH"));
   }

   public void changeLocale() {
      this.setText(Constant.t("NEW"));
   }
}