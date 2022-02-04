package ui.Drawing.Labyrinthe;

import javax.swing.event.MouseInputListener;
import javax.swing.event.MouseInputAdapter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import ui.Drawing.DrawingApp;
import ui.Drawing.Labyrinthe.Elements.Square;

public class DrawingPanelMouseListenerLaby extends MouseInputAdapter implements MouseInputListener {
   private final Square square;
   private final DrawingApp drawingApp;

   public DrawingPanelMouseListenerLaby(DrawingApp drawingApp, Square square) {
      super(); // Button's text
      this.drawingApp = drawingApp;
      this.square = square;
   }

   @Override
   public final void mousePressed(MouseEvent e) {
      drawingApp.getDrawingAppModelLaby().setClicked(true);
   }

   @Override
   public final void mouseDragged(MouseEvent e) {
      // System.out.println("drag");
   }

   @Override
   public final void mouseReleased(MouseEvent e) {
      drawingApp.getDrawingAppModelLaby().setClicked(false);
   }

   @Override
   public final void mouseEntered(MouseEvent e) {
      // System.out.println("entrée");
      if (drawingApp.getDrawingAppModelLaby().getClicked()) {
         this.square.changeColor(Color.BLACK); // only black
      }
   }

   @Override
   public final void mouseExited(MouseEvent e) {
      // System.out.println("sortie");
   }

   @Override
   public final void mouseClicked(MouseEvent e) {
      if (this.square != null) {
         this.square.changeColor(null); // defautlt actions
      } else if (drawingApp != null) {
         drawingApp.stateChanged(null);
      }
   }

}