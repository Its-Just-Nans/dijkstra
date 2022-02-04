package ui.Menu.Labyrinthe;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;
import ui.Utils.Modal;

public class SolveLabyMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public SolveLabyMenuItem(DrawingApp drawingApp) {
      super(Constant.t("SOLVE")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      int caseHeight = Modal.ask(Constant.t("SQUARE_SIZE"), 10, 5, 50);
      this.drawingApp.getDrawingAppModelLaby().setSquareSize(caseHeight);
   }

   public void changeLocale() {
      this.setText(Constant.t("SOLVE"));
   }

}