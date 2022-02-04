package ui.Menu.FileMenu;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Utils.Constant;
import ui.Utils.Modal;
import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingAppModel;

public class AboutMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public AboutMenuItem(DrawingApp drawingApp) {
      super(Constant.t("ABOUT")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      Modal.showAbout();
   }

   public void changeLocale() {
      this.setText(Constant.t("ABOUT"));
   }
}