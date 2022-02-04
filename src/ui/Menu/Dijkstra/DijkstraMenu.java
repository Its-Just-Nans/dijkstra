package ui.Menu.Dijkstra;

import javax.swing.JMenu;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class DijkstraMenu extends JMenu {
   NewMenuItem newMenuItem;
   SwitchMenuItem switchMenuItem;
   SolveMenuItem solveMenuItem;

   public DijkstraMenu(DrawingApp drawingApp) {
      super(Constant.t("GRAPH")); // Text of the menu

      add(newMenuItem = new NewMenuItem(drawingApp));
      add(switchMenuItem = new SwitchMenuItem(drawingApp));
      add(solveMenuItem = new SolveMenuItem(drawingApp));
   }

   public void changeLocale() {
      this.setText(Constant.t("GRAPH"));
      newMenuItem.changeLocale();
      switchMenuItem.changeLocale();
      solveMenuItem.changeLocale();
   }
}