package ui.Menu.FileMenu;

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
   }

}