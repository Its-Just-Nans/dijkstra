package ui.Menu.FileMenu;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingAppModel;
import ui.Utils.Constant;
import ui.Utils.Modal;

public class QuitMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public QuitMenuItem(DrawingApp drawingApp) {
      super(Constant.t("LEAVE")); // Text of menu item

      this.drawingApp = drawingApp;

      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();

      if (drawingAppModel.isModified()) {
         boolean test = Modal.showYesOrNo(Constant.t("QUIT"), "SAVE");
         if (test) {
            drawingAppModel.saveToFile();
         }
      }
      System.exit(0);
   }

   public void changeLocale() {
      this.setText(Constant.t("LEAVE"));
   }
}