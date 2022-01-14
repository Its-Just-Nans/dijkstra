package ui.Drawing;

import javax.swing.event.MouseInputListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanelMouseListener extends MouseInputAdapter implements MouseInputListener {
   private final DrawingApp drawingApp;

   public DrawingPanelMouseListener(DrawingApp drawingApp) {
      super(); // Button's text

      this.drawingApp = drawingApp;
   }

   @Override
   public final void mousePressed(MouseEvent e) {
      drawingApp.getDrawingAppModel().initCurrentForme(e.getX(), e.getY());
   }

   @Override
   public final void mouseDragged(MouseEvent e) {
      System.out.println("MOUSE");
      drawingApp.getDrawingAppModel().modifyCurrentForme(e.getX(), e.getY());
   }

   @Override
   public final void mouseReleased(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme() == "Segment") {
         drawingApp.getDrawingAppModel().registerCurrentSegment(e.getX(), e.getY());
      }
   }

   @Override
   public final void mouseExited(MouseEvent e) {
      drawingApp.getDrawingAppModel().cancelCurrentForme();
   }

   @Override
   public final void mouseClicked(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme() == "Cursor") {
         drawingApp.getDrawingAppModel().setSelection(e.getX(), e.getY());
      }
   }
}