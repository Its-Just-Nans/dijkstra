package ui;

import javax.swing.event.*;
import java.awt.event.MouseEvent;

public class DrawingPanelMouseListener extends MouseInputAdapter implements MouseInputListener, MouseMotionListener {
   private final DrawingApp drawingApp;

   public DrawingPanelMouseListener(DrawingApp drawingApp) {
      super(); // Button's text

      this.drawingApp = drawingApp;
   }

   @Override
   public final void mousePressed(MouseEvent e) {
      drawingApp.getDrawingAppModel().initCurrentSegment(e.getX(), e.getY());
   }

   @Override
   public final void mouseDragged(MouseEvent e) {
      drawingApp.getDrawingAppModel().modifyCurrentSegment(e.getX(), e.getY());
   }

   @Override
   public final void mouseReleased(MouseEvent e) {
      drawingApp.getDrawingAppModel().registerCurrentSegment(e.getX(), e.getY());
   }

   @Override
   public final void mouseExited(MouseEvent e) {
      drawingApp.getDrawingAppModel().cancelCurrentSegment();
   }

   @Override
   public final void mouseClicked(MouseEvent e) {
      drawingApp.getDrawingAppModel().setSelection(e.getX(), e.getY());
   }
}