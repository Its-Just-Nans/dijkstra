package ui.Menu.FileMenu;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class QuitMenuItem extends JMenuItem implements ActionListener {
   public QuitMenuItem(DrawingApp drawingApp) {
      super(Constant.t("LEAVE")); // Text of menu item
      addActionListener(this);
   }

   /**
    * @param evt
    */
   public void actionPerformed(ActionEvent evt) {
      System.exit(0);
   }

   public void changeLocale() {
      this.setText(Constant.t("LEAVE"));
   }
}