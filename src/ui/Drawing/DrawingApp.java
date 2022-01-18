package ui.Drawing;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import ui.WindowPanel;
import ui.Drawing.Elements.Cercle;
import ui.Menu.DrawingMenuBar;

public class DrawingApp extends JFrame implements ChangeListener {
   private final DrawingMenuBar drawingMenuBar;
   private final WindowPanel windowPanel;
   private DrawingAppModel drawingAppModel = new DrawingAppModel();

   public DrawingApp() {
      super("Drawing Application"); // Window title
      setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
      setContentPane(windowPanel = new WindowPanel(this));

      drawingAppModel.addObserver(this);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Explicit !

      pack(); // Components sizes and positions
      setVisible(true); // The great show
   }

   public DrawingAppModel getDrawingAppModel() {
      return drawingAppModel;
   }

   public void setDrawingAppModel(DrawingAppModel drawingAppModel) {
      this.drawingAppModel = drawingAppModel;
   }

   public void stateChanged(ChangeEvent evt) {
      windowPanel.notifyForUpdate();
   }

   public void solveDijkstra() {
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
   }
}