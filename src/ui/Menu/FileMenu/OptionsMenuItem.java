package ui.Menu.FileMenu;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Drawing.Dijkstra.DrawingAppModel;
import ui.Utils.Constant;
import ui.Utils.Modal;

public class OptionsMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public OptionsMenuItem(DrawingApp drawingApp) {
      super(Constant.t("OPTIONS")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      Modal.showOptions(drawingApp);
   }

   public void changeLocale() {
      this.setText(Constant.t("OPTIONS"));
   }
}