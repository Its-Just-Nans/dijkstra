package ui.Menu.Dijkstra;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class SolveMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public SolveMenuItem(DrawingApp drawingApp) {
      super(Constant.t("SOLVE")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.getDrawingAppModel().solveDijkstra();
   }

   public void changeLocale() {
      this.setText(Constant.t("SOLVE"));
   }
}