package ui.Menu.FileMenu;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Utils.Constant;
import ui.Utils.Modal;
import ui.Drawing.DrawingApp;

public class AboutMenuItem extends JMenuItem implements ActionListener {
   public AboutMenuItem(DrawingApp drawingApp) {
      super(Constant.t("ABOUT")); // Text of menu item
      addActionListener(this);
   }

   /**
    * @param evt
    */
   public void actionPerformed(ActionEvent evt) {
      Modal.showAbout();
   }

   public void changeLocale() {
      this.setText(Constant.t("ABOUT"));
   }
}