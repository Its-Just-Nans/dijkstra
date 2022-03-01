package ui.Menu.FileMenu;

<<<<<<< HEAD
import javax.swing.*;
import java.awt.event.*;

import ui.Drawing.*;
import ui.DrawingApp;
=======
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingAppModel;
import ui.Utils.Constant;
import ui.Utils.Modal;
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2

public class QuitMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public QuitMenuItem(DrawingApp drawingApp) {
<<<<<<< HEAD
      super("Quitter"); // Text of menu item
=======
      super(Constant.t("LEAVE")); // Text of menu item
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2

      this.drawingApp = drawingApp;

      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();

      if (drawingAppModel.isModified()) {
<<<<<<< HEAD
         int response = JOptionPane.showInternalOptionDialog(this,
               "Drawing not saved. Save it ?",
               "Quit application",
               JOptionPane.YES_NO_CANCEL_OPTION,
               JOptionPane.WARNING_MESSAGE,
               null, null, null);
         switch (response) {
            case JOptionPane.CANCEL_OPTION:
               return;
            case JOptionPane.OK_OPTION:
               drawingAppModel.saveToFile();
               break;
            case JOptionPane.NO_OPTION:
               break;
=======
         boolean test = Modal.showYesOrNo(Constant.t("QUIT"), "SAVE");
         if (test) {
            drawingAppModel.saveToFile();
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2
         }
      }
      System.exit(0);
   }

<<<<<<< HEAD
=======
   public void changeLocale() {
      this.setText(Constant.t("LEAVE"));
   }
>>>>>>> 33f66416d59e4e2af5c96c946648a6dda8e903f2
}