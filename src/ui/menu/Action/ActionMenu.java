package ui.menu.Action;

import javax.swing.*;

import ui.DrawingApp;

public class ActionMenu extends JMenu {
   private final OpenFileMenuItem openFileItem;

   public ActionMenu(DrawingApp drawingApp) {
      super("Action"); // Text of the menu

      // Create and add menu items
      this.openFileItem = new OpenFileMenuItem(drawingApp);
      add(this.openFileItem);
   }

}