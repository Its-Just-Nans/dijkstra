package ui.Menu.Labyrinthe;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class SolveLabyMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public SolveLabyMenuItem(DrawingApp drawingApp) {
      super(Constant.t("SOLVE")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   /**
    * @param evt
    */
   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.changeTo(Constant.cst("LABY"), true);
      this.drawingApp.getDrawingAppModelLaby().solveDijkstra();
   }

   public void changeLocale() {
      this.setText(Constant.t("SOLVE"));
   }

}