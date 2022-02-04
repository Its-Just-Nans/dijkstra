package ui.Drawing.Dijkstra;

import javax.swing.event.MouseInputListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class DrawingPanelMouseListenerDijkstra extends MouseInputAdapter implements MouseInputListener {
   private final DrawingApp drawingApp;

   public DrawingPanelMouseListenerDijkstra(DrawingApp drawingApp) {
      super(); // Button's text

      this.drawingApp = drawingApp;
   }

   @Override
   public final void mousePressed(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme() == Constant.CURSOR) {
         this.mouseClicked(e);
         drawingApp.getDrawingAppModel().moveCirle(e.getX(), e.getY());
      } else {
         // we init a new form
         drawingApp.getDrawingAppModel().initCurrentForme(e.getX(), e.getY());
      }
   }

   @Override
   public final void mouseDragged(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme() == Constant.SEGMENT) {
         drawingApp.getDrawingAppModel().modifyCurrentForme(e.getX(), e.getY());
      } else if (drawingApp.getDrawingAppModel().getCurrentForme() == Constant.CURSOR
            && drawingApp.getDrawingAppModel().getSelectionType() == Constant.CERCLE) {
         drawingApp.getDrawingAppModel().moveCirle(e.getX(), e.getY());
      }
   }

   @Override
   public final void mouseReleased(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme() == Constant.SEGMENT) {
         drawingApp.getDrawingAppModel().registerCurrentSegment(e.getX(), e.getY());
      } else if (drawingApp.getDrawingAppModel().getCurrentForme() == Constant.CURSOR
            && drawingApp.getDrawingAppModel().getSelectionType() == Constant.CERCLE) {
         drawingApp.getDrawingAppModel().endMoveCirle(e.getX(), e.getY());
      }
   }

   @Override
   public final void mouseExited(MouseEvent e) {
      drawingApp.getDrawingAppModel().cancelCurrentForme();
   }

   @Override
   public final void mouseClicked(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme() == Constant.CURSOR) {
         drawingApp.getDrawingAppModel().setSelection(e.getX(), e.getY());
      }
   }
}