package ui.Menu.Dijkstra;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Constant;
import ui.Drawing.DrawingApp;

public class NewMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public NewMenuItem(DrawingApp drawingApp) {
      super(Constant.ACTIVATE); // Text of menu item

      this.drawingApp = drawingApp;

      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.changeTo(Constant.GRAPH);
   }
}