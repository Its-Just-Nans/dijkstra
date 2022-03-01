package ui.Menu.FileMenu;

<<<<<<< HEAD
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
=======
import javax.swing.JMenu;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class FileMenu extends JMenu {
   private QuitMenuItem quitMenuItem;
   private AboutMenuItem aboutMenuItem;
   private OptionsMenuItem optionsMenuItem;

   public FileMenu(DrawingApp drawingApp) {
      super(Constant.t("FILE")); // Text of the menu

      // Create and add menu items
      add(quitMenuItem = new QuitMenuItem(drawingApp));
      add(aboutMenuItem = new AboutMenuItem(drawingApp));
      add(optionsMenuItem = new OptionsMenuItem(drawingApp));
   }

   public void changeLocale() {
      this.setText(Constant.t("FILE"));
      quitMenuItem.changeLocale();
      aboutMenuItem.changeLocale();
      optionsMenuItem.changeLocale();
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2
   }

}