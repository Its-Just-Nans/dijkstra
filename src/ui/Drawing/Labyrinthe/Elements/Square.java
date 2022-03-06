package ui.Drawing.Labyrinthe.Elements;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import maze.MBox;
import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class Square extends JPanel {
    private int x;
    private int y;
    private DrawingApp drawingApp;
    private MBox box;

    public Square(DrawingApp drawingApp, MBox mbox) {
        super();
        this.drawingApp = drawingApp;
        int cubeSize = this.drawingApp.getDrawingAppModelLaby().getSquareSize();
        this.setPreferredSize(new Dimension(cubeSize, cubeSize));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBox(mbox);
    }

    /**
     * @param mbox
     */
    public void setBox(MBox mbox) {
        this.box = mbox;
        this.box.setX(this.x);
        this.box.setY(this.y);
        this.setPanelBackground();
    }

    /**
     * @param x
     * @param y
     */
    public void setCoord(int x, int y) {
        this.x = x;
        this.y = y;
        this.box.setX(this.x);
        this.box.setY(this.y);
    }

    /**
     * @return String
     */
    public String getBoxType() {
        return this.box.getType();
    }

    /**
     * @return MBox
     */
    public MBox getBox() {
        return this.box;
    }

    private void setPanelBackground() {
        Color temp;
        String typeOfBox = Constant.convertType(box.getType());
        if (typeOfBox.equals(Constant.cst("START"))) {
            MBox tempBox = this.getBox();
            this.drawingApp.getDrawingAppModelLaby().resetCase(Constant.cst("START"));
            this.box = tempBox;
            temp = Color.BLUE;
        } else if (typeOfBox.equals(Constant.cst("END"))) {
            MBox tempBox = this.getBox();
            this.drawingApp.getDrawingAppModelLaby().resetCase(Constant.cst("END"));
            this.box = tempBox;
            temp = Color.RED;
        } else if (typeOfBox.equals(Constant.cst("WALL"))) {
            temp = Color.BLACK;
        } else if (typeOfBox.equals(Constant.cst("FINAL"))) {
            temp = Color.YELLOW;
        } else {
            // (typeOfBox.equals(Constant.cst("NORMAL"))
            temp = Color.WHITE; // default value
        }
        this.setBackground(temp);
    }
}