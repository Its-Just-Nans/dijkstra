package ui.Menu.Action;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;

public class OpenFileMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public OpenFileMenuItem(DrawingApp drawingApp) {
      super("Ouvrir un fichier"); // Text of menu item

      this.drawingApp = drawingApp;

      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.solveDijkstra();
   }
}