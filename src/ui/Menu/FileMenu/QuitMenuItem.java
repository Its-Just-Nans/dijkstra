package ui.Menu.FileMenu;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingAppModel;

public class QuitMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public QuitMenuItem(DrawingApp drawingApp) {
      super("Quitter"); // Text of menu item

      this.drawingApp = drawingApp;

      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();

      if (drawingAppModel.isModified()) {
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
         }
      }
      System.exit(0);
   }

}