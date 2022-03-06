package ui.Drawing.Dijkstra;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class DrawingPanelMouseListenerDijkstra extends MouseInputAdapter {
   private final DrawingApp drawingApp;

   public DrawingPanelMouseListenerDijkstra(DrawingApp drawingApp) {
      super(); // Button's text

      this.drawingApp = drawingApp;
   }

   /**
    * Event mousePressed
    * 
    * @param e
    */
   @Override
   public final void mousePressed(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme().equals(Constant.cst("CURSOR"))) {
         this.mouseClicked(e);
         drawingApp.getDrawingAppModel().moveCirle(e.getX(), e.getY());
      } else {
         // we init a new form
         drawingApp.getDrawingAppModel().initCurrentForme(e.getX(), e.getY());
      }
   }

   /**
    * Event mouseDragged (drag des boutons et segments)
    * 
    * @param e
    */
   @Override
   public final void mouseDragged(MouseEvent e) {
      String tempForme = drawingApp.getDrawingAppModel().getCurrentForme();
      if (tempForme.equals(Constant.cst("SEGMENT"))) {
         drawingApp.getDrawingAppModel().modifyCurrentForme(e.getX(), e.getY());
      } else if (tempForme.equals(Constant.cst("CURSOR"))
            && drawingApp.getDrawingAppModel().getSelectionType().equals(Constant.cst("CERCLE"))) {
         drawingApp.getDrawingAppModel().moveCirle(e.getX(), e.getY());
      }
   }

   /**
    * event mouseReleased (enregistre le segment ou bouge le cercle)
    * 
    * @param e
    */
   @Override
   public final void mouseReleased(MouseEvent e) {
      String current = drawingApp.getDrawingAppModel().getCurrentForme();
      String select = drawingApp.getDrawingAppModel().getSelectionType();
      if (current.equals(Constant.cst("SEGMENT"))) {
         drawingApp.getDrawingAppModel().registerCurrentSegment(e.getX(), e.getY());
      } else if (current.equals(Constant.cst("CURSOR"))
            && select.equals(Constant.cst("CERCLE"))) {
         drawingApp.getDrawingAppModel().endMoveCirle(e.getX(), e.getY());
      }
   }

   /**
    * Event mouseExisted - arrêter le dessin
    * 
    * @param e
    */
   @Override
   public final void mouseExited(MouseEvent e) {
      drawingApp.getDrawingAppModel().cancelCurrentForme();
   }

   /**
    * event mouseClicked - active la selection si c'est le curseur
    * 
    * @param e
    */
   @Override
   public final void mouseClicked(MouseEvent e) {
      if (drawingApp.getDrawingAppModel().getCurrentForme().equals(Constant.cst("CURSOR"))) {
         drawingApp.getDrawingAppModel().setSelection(e.getX(), e.getY());
      }
   }
}