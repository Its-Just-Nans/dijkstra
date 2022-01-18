package ui.Buttons;

import java.awt.GridLayout;
import javax.swing.JPanel;

import ui.Drawing.DrawingApp;

public class ButtonsOptions extends JPanel {
    private final EraseButton eraseSegment;
    private final ListType listType;
    private final DrawingApp drawingApp;

    public ButtonsOptions(DrawingApp drawingApp) {
        super();
        setLayout(new GridLayout(3, 1)); // 1 row, 4 columns
        add(eraseSegment = new EraseButton(drawingApp));
        add(listType = new ListType(drawingApp));

        this.drawingApp = drawingApp;
    }

    public void notifyForUpdate() {
        eraseSegment.notifyForUpdate();
        listType.notifyForUpdate();
    }
}