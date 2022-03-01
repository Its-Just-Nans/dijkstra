package ui.Menu.Action;

import javax.swing.*;

import ui.DrawingApp;

import java.awt.event.*;

public class OpenFileMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public OpenFileMenuItem(DrawingApp drawingApp) {
      super("Ouvrir un fichier"); // Text of menu item

      this.drawingApp = drawingApp;

      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      System.out.println("CLICK");
   }
}