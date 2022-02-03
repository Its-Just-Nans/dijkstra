package ui.Menu.Labyrinthe;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Constant;
import ui.Drawing.DrawingApp;
import ui.Utils.Questions;

public class SolveLabyMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public SolveLabyMenuItem(DrawingApp drawingApp) {
      super(Constant.SOLVE); // Text of menu item

      this.drawingApp = drawingApp;

      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      int caseHeight = Questions.ask("Entrer la taille des cases", 10, 5, 50);
      this.drawingApp.getDrawingAppModelLaby().setSquareSize(caseHeight);
   }

}