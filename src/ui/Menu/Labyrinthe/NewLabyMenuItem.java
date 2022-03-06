package ui.Menu.Labyrinthe;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class NewLabyMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public NewLabyMenuItem(DrawingApp drawingApp) {
      super(Constant.t("NEW")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   /**
    * @param evt
    */
   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.newGame(Constant.cst("LABY"));
   }

   public void changeLocale() {
      this.setText(Constant.t("NEW"));
   }
}