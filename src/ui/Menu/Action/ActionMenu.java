package ui.Menu.Action;

import javax.swing.JMenu;

import ui.Drawing.DrawingApp;

public class ActionMenu extends JMenu {
   private final OpenFileMenuItem openFileItem;

   public ActionMenu(DrawingApp drawingApp) {
      super("Action"); // Text of the menu

      // Create and add menu items
      this.openFileItem = new OpenFileMenuItem(drawingApp);
      add(this.openFileItem);
   }

}