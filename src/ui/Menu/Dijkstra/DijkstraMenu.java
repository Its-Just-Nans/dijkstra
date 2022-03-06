package ui.Menu.Dijkstra;

import javax.swing.JMenu;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class DijkstraMenu extends JMenu {
   private final NewMenuItem newMenuItem;
   private final SwitchMenuItem switchMenuItem;
   private final SolveMenuItem solveMenuItem;
   private final HelpMenuItem helpMenuItem;

   public DijkstraMenu(DrawingApp drawingApp) {
      super(Constant.t("GRAPH")); // Text of the menu

      add(newMenuItem = new NewMenuItem(drawingApp));
      add(switchMenuItem = new SwitchMenuItem(drawingApp));
      add(solveMenuItem = new SolveMenuItem(drawingApp));
      add(helpMenuItem = new HelpMenuItem(drawingApp));
   }

   public void changeLocale() {
      this.setText(Constant.t("GRAPH"));
      newMenuItem.changeLocale();
      switchMenuItem.changeLocale();
      solveMenuItem.changeLocale();
      helpMenuItem.changeLocale();
   }
}