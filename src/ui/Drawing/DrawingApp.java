package ui.Drawing;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import ui.Constant;
import ui.Drawing.Dijkstra.DrawingAppModel;
import ui.Drawing.Dijkstra.WindowPanel;
import ui.Drawing.Dijkstra.Elements.Cercle;
import ui.Drawing.Labyrinthe.DrawingAppModelLaby;
import ui.Menu.DrawingMenuBar;
import ui.Utils.Questions;
import ui.Drawing.Labyrinthe.WindowPanelLaby;
import ui.Drawing.Labyrinthe.Elements.Square;

public class DrawingApp extends JFrame implements ChangeListener {
   private final DrawingMenuBar drawingMenuBar;
   private final WindowPanel windowPanel;
   private final WindowPanelLaby windowPanelLaby;
   private DrawingAppModel drawingAppModel = new DrawingAppModel();
   private DrawingAppModelLaby drawingAppModelLaby = new DrawingAppModelLaby();
   private String windowType = null;

   public DrawingApp() {
      super("Drawing Application"); // Window title

      this.drawingMenuBar = new DrawingMenuBar(this);
      this.setJMenuBar(drawingMenuBar);

      this.windowPanel = new WindowPanel(this);
      this.windowPanelLaby = new WindowPanelLaby(this);

      drawingAppModel.addObserver(this);
      // drawingAppModelLaby.addObserver(this);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Explicit !
      this.changeTo(Constant.LABY);

      pack();
      setVisible(true); // The great show
   }

   public DrawingAppModel getDrawingAppModel() {
      return drawingAppModel;
   }

   public DrawingAppModelLaby getDrawingAppModelLaby() {
      return drawingAppModelLaby;
   }

   public void changeTo(String newType) {
      if (this.windowType != newType) {
         windowPanelLaby.setVisible(false);
         windowPanel.setVisible(false);
         if (newType == Constant.LABY) {
            int labyHeight = Questions.ask("Entrer la taille du labyrinthe", 10, 5, 50);
            this.windowPanelLaby.setTheHeight(labyHeight);
            windowPanelLaby.setVisible(true);
            this.setContentPane(this.windowPanelLaby);
         } else if (newType == Constant.GRAPH) {
            windowPanel.setVisible(true);
            this.setContentPane(this.windowPanel);
         }
         this.windowType = newType;
         this.pack();
         this.stateChanged(null);
      }

   }

   public void setDrawingAppModel(DrawingAppModel drawingAppModel) {
      this.drawingAppModel = drawingAppModel;
   }

   public void stateChanged(ChangeEvent evt) {
      if (windowType == Constant.LABY) {
         windowPanelLaby.notifyForUpdate();
      } else if (windowType == Constant.GRAPH) {
         windowPanel.notifyForUpdate();
      }
   }

   public void solveDijkstra() {
      if (windowType.equals(Constant.GRAPH)) {

         this.drawingAppModel = this.getDrawingAppModel();
         // drawingAppModel.cleanInterface();
         // drawingAppModel.checkValues();
         VertexInterface start = drawingAppModel.getStart();
         VertexInterface end = drawingAppModel.getEnd();
         PreviousInterface chemin = Dijkstra.dijkstra(drawingAppModel, start);

         Cercle endCaseTemp = (Cercle) end;
         while (endCaseTemp.getLabel() != start.getLabel()) {
            endCaseTemp = (Cercle) chemin.getValue(endCaseTemp);
            if (endCaseTemp != null) {
               drawingAppModel.setCaseWIN(endCaseTemp.getRealX(), endCaseTemp.getRealY());
            }
         }
      } else if (windowType.equals(Constant.LABY)) {
         this.drawingAppModelLaby = this.getDrawingAppModelLaby();

      }
   }
}