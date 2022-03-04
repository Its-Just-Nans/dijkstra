package ui.Menu.Labyrinthe;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;
import ui.Utils.Modal;

public class SaveToFileMenuItem extends JMenuItem implements ActionListener {
   private final DrawingApp drawingApp;

   public SaveToFileMenuItem(DrawingApp drawingApp) {
      super(Constant.t("SAVE_TO_FILE")); // Text of menu item
      this.drawingApp = drawingApp;
      addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      this.drawingApp.changeTo(Constant.cst("LABY"), true);
      String path = Modal.filePathChooser();
      if (path == null) {
         return;
      }
      this.drawingApp.getDrawingAppModelLaby().saveToFile(path);
   }

   public void changeLocale() {
      this.setText(Constant.t("SAVE_TO_FILE"));
   }

}