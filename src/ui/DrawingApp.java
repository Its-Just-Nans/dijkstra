package ui;

import model.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
}