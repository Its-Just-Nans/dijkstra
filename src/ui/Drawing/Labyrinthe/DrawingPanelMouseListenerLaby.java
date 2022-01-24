package ui.Drawing.Labyrinthe;

import javax.swing.event.MouseInputListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

import ui.Constant;
import ui.Drawing.DrawingApp;

public class DrawingPanelMouseListenerLaby extends MouseInputAdapter implements MouseInputListener {
   private final DrawingApp drawingApp;

   public DrawingPanelMouseListenerLaby(DrawingApp drawingApp) {
      super(); // Button's text

      this.drawingApp = drawingApp;
   }

   @Override
   public final void mousePressed(MouseEvent e) {
      this.mouseClicked(e);
      //
   }

   @Override
   public final void mouseDragged(MouseEvent e) {
      //
   }

   @Override
   public final void mouseReleased(MouseEvent e) {
      //
   }

   @Override
   public final void mouseExited(MouseEvent e) {
      //
   }

   @Override
   public final void mouseClicked(MouseEvent e) {
      drawingApp.getDrawingAppModelLaby().setSelection(e.getX(), e.getY());
   }
}