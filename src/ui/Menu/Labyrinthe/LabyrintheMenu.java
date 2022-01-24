package ui.Menu.Labyrinthe;

import java.io.Console;

import javax.swing.JMenu;

import ui.Constant;
import ui.Drawing.DrawingApp;

public class LabyrintheMenu extends JMenu {
   private final SolveLabyMenuItem solveLabyMenuItem;
   private final NewLabyMenuItem newLabyMenuItem;
   private DrawingApp drawingApp;

   public LabyrintheMenu(DrawingApp drawingApp) {
      super(Constant.LABY); // Text of the menu
      this.drawingApp = drawingApp;

      // Create and add menu items
      this.newLabyMenuItem = new NewLabyMenuItem(drawingApp);
      add(this.newLabyMenuItem);
      this.solveLabyMenuItem = new SolveLabyMenuItem(drawingApp);
      add(this.solveLabyMenuItem);
   }
}