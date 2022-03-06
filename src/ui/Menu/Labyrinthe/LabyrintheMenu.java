package ui.Menu.Labyrinthe;

import javax.swing.JMenu;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class LabyrintheMenu extends JMenu {
   private final NewLabyMenuItem newLabyMenuItem;
   private final SwitchLabyMenuItem switchLabyMenuItem;
   private final SolveLabyMenuItem solveLabyMenuItem;
   private final InitFromFileMenuItem initFromFileMenuItem;
   private final SaveToFileMenuItem saveToFileMenuItem;
   private final HelpLabyMenuItem helpLabyMenuItem;

   public LabyrintheMenu(DrawingApp drawingApp) {
      super(Constant.t("LABY")); // Text of the menu
      add(newLabyMenuItem = new NewLabyMenuItem(drawingApp));
      add(switchLabyMenuItem = new SwitchLabyMenuItem(drawingApp));
      add(solveLabyMenuItem = new SolveLabyMenuItem(drawingApp));
      add(initFromFileMenuItem = new InitFromFileMenuItem(drawingApp));
      add(saveToFileMenuItem = new SaveToFileMenuItem(drawingApp));
      add(helpLabyMenuItem = new HelpLabyMenuItem(drawingApp));
   }

   public void changeLocale() {
      this.setText(Constant.t("LABY"));
      newLabyMenuItem.changeLocale();
      switchLabyMenuItem.changeLocale();
      solveLabyMenuItem.changeLocale();
      initFromFileMenuItem.changeLocale();
      saveToFileMenuItem.changeLocale();
      helpLabyMenuItem.changeLocale();
   }
}