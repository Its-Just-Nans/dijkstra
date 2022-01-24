package ui.Menu.Dijkstra;

import javax.swing.JMenu;

import ui.Constant;
import ui.Drawing.DrawingApp;

public class DijkstraMenu extends JMenu {
   private final SolveMenuItem openFileItem;
   private final NewMenuItem newMenuItem;

   public DijkstraMenu(DrawingApp drawingApp) {
      super(Constant.DIJKSTRA); // Text of the menu

      // Create and add menu items
      this.newMenuItem = new NewMenuItem(drawingApp);
      add(this.newMenuItem);
      this.openFileItem = new SolveMenuItem(drawingApp);
      add(this.openFileItem);
   }

}