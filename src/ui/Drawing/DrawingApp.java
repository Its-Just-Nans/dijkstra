package ui.Drawing;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import ui.Drawing.Dijkstra.DrawingAppModel;
import ui.Drawing.Dijkstra.WindowPanel;
import ui.Drawing.Dijkstra.Elements.Cercle;
import ui.Drawing.Labyrinthe.DrawingAppModelLaby;
import ui.Menu.DrawingMenuBar;
import ui.Utils.Constant;
import ui.Utils.Modal;
import ui.Drawing.Labyrinthe.WindowPanelLaby;

public class DrawingApp extends JFrame implements ChangeListener {
   private final DrawingMenuBar drawingMenuBar;
   private final WindowPanel windowPanel;
   private final WindowPanelLaby windowPanelLaby;
   private DrawingAppModel drawingAppModel;
   private DrawingAppModelLaby drawingAppModelLaby;
   private String windowType = null;

   public DrawingApp() {
      super("Drawing Application"); // Window title
      this.drawingAppModel = new DrawingAppModel();
      this.drawingAppModelLaby = new DrawingAppModelLaby(this);

      this.drawingMenuBar = new DrawingMenuBar(this);
      this.setJMenuBar(drawingMenuBar);
      this.windowPanel = new WindowPanel(this);
      this.windowPanelLaby = new WindowPanelLaby(this);

      drawingAppModel.addObserver(this);
      // drawingAppModelLaby.addObserver(this);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Explicit !
      this.changeTo(Constant.cst("GRAPH"), false);

      pack();
      setVisible(true); // The great show
   }

   public DrawingAppModel getDrawingAppModel() {
      return drawingAppModel;
   }

   public DrawingAppModelLaby getDrawingAppModelLaby() {
      return drawingAppModelLaby;
   }

   public void changeTo(String newType, boolean force) {
      if (this.windowType != newType) {
         windowPanelLaby.setVisible(false);
         windowPanel.setVisible(false);
         if (newType.equals(Constant.cst("LABY"))) {
            windowPanelLaby.setVisible(true);
            this.setContentPane(this.windowPanelLaby);
         } else if (newType.equals(Constant.cst("GRAPH"))) {
            windowPanel.setVisible(true);
            this.setContentPane(this.windowPanel);
         }
         this.windowType = newType;
         this.pack();
         this.stateChanged(null);
      } else {
         if (force == false) {
            Modal.makeMessage(Constant.t("MSG_SWITCH"));
         }
      }
   }

   public void setDrawingAppModel(DrawingAppModel drawingAppModel) {
      this.drawingAppModel = drawingAppModel;
   }

   public void stateChanged(ChangeEvent evt) {
      if (windowType.equals(Constant.cst("LABY"))) {
         windowPanelLaby.notifyForUpdate();
      } else if (windowType.equals(Constant.cst("GRAPH"))) {
         windowPanel.notifyForUpdate();
      }
   }

   public WindowPanelLaby getWindowPanelLaby() {
      return windowPanelLaby;
   }

   public void newGame(String newType) {
      windowPanelLaby.setVisible(false);
      windowPanel.setVisible(false);
      if (newType.equals(Constant.cst("LABY"))) {
         int labyWidth = Modal.ask(Constant.t("GET_WIDTH"), 10, 5, 50);
         int labyHeight = Modal.ask(Constant.t("GET_HEIGHT"), 10, 5, 50);
         this.windowPanelLaby.setDimensions(labyHeight, labyWidth);
         this.windowPanelLaby.generateLaby(labyHeight, labyWidth);
         windowPanelLaby.setVisible(true);
         this.setContentPane(this.windowPanelLaby);
      } else if (newType.equals(Constant.cst("GRAPH"))) {
         this.drawingAppModel.resetGame();
         windowPanel.setVisible(true);
         this.setContentPane(this.windowPanel);
      }
      this.windowType = newType;
      this.pack();
      this.stateChanged(null);
   }

   public void changeLocale() {
      windowPanel.changeLocale();
      // windowPanelLaby.changeLocale();
      drawingMenuBar.changeLocale();
   }
}