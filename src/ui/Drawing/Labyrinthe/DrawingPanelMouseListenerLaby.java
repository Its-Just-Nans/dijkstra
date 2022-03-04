package ui.Drawing.Labyrinthe;

import javax.swing.event.MouseInputAdapter;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MBox;
import maze.WBox;

import java.awt.Color;
import java.awt.event.MouseEvent;

import ui.Drawing.DrawingApp;
import ui.Drawing.Labyrinthe.Elements.Square;
import ui.Utils.Constant;

public class DrawingPanelMouseListenerLaby extends MouseInputAdapter {
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
         this.square.setBox(new WBox()); // only black
         drawingApp.getDrawingAppModelLaby().stateChanges();
      }
   }

   @Override
   public final void mouseExited(MouseEvent e) {
      // System.out.println("sortie");
   }

   @Override
   public final void mouseClicked(MouseEvent e) {
      if (this.square != null) {
         String typeOfBox = Constant.convertType(this.square.getBox().getType());
         MBox temp;
         if (typeOfBox.equals(Constant.cst("START"))) {
            temp = new ABox();
         } else if (typeOfBox.equals(Constant.cst("END"))) {
            temp = new EBox();
         } else if (typeOfBox.equals(Constant.cst("WALL"))) {
            temp = new DBox();
         } else if (typeOfBox.equals(Constant.cst("FINAL"))) {
            temp = new EBox();
         } else {
            // (typeOfBox.equals(Constant.cst("NORMAL"))
            temp = new WBox(); // default value
         }
         this.square.setBox(temp);
      } else if (drawingApp != null) {
         drawingApp.stateChanged(null);
      }
   }

}