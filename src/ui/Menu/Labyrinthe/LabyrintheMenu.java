package ui.Menu.Labyrinthe;

import javax.swing.JMenu;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class LabyrintheMenu extends JMenu {
   private NewLabyMenuItem newLabyMenuItem;
   private SwitchLabyMenuItem switchLabyMenuItem;
   private SolveLabyMenuItem solveLabyMenuItem;
   private InitFromFileMenuItem initFromFileMenuItem;

   public LabyrintheMenu(DrawingApp drawingApp) {
      super(Constant.t("LABY")); // Text of the menu
      add(newLabyMenuItem = new NewLabyMenuItem(drawingApp));
      add(switchLabyMenuItem = new SwitchLabyMenuItem(drawingApp));
      add(solveLabyMenuItem = new SolveLabyMenuItem(drawingApp));
      add(initFromFileMenuItem = new InitFromFileMenuItem(drawingApp));
   }

   public void changeLocale() {
      this.setText(Constant.t("LABY"));
      newLabyMenuItem.changeLocale();
      switchLabyMenuItem.changeLocale();
      solveLabyMenuItem.changeLocale();
      initFromFileMenuItem.changeLocale();
   }
}