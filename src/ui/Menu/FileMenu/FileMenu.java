package ui.Menu.FileMenu;

import javax.swing.*;

import ui.*;
import ui.Drawing.*;
import ui.DrawingApp;

public class FileMenu extends JMenu {
   private final QuitMenuItem quitMenuItem;

   public FileMenu(DrawingApp drawingApp) {
      super("File"); // Text of the menu

      // Create and add menu items
      add(this.quitMenuItem = new QuitMenuItem(drawingApp));
   }

}