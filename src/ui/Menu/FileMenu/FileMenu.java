package ui.Menu.FileMenu;

import javax.swing.JMenu;

import ui.Drawing.DrawingApp;

public class FileMenu extends JMenu {
   private final QuitMenuItem quitMenuItem;

   public FileMenu(DrawingApp drawingApp) {
      super("File"); // Text of the menu

      // Create and add menu items
      add(this.quitMenuItem = new QuitMenuItem(drawingApp));
   }

}