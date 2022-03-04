package ui.Buttons;

import java.awt.GridLayout;
import javax.swing.JPanel;

import ui.Drawing.DrawingApp;
import ui.Utils.Constant;

public class ButtonsOptions extends JPanel {
    private final EraseButton eraseSegment;
    private final ListType listType;
    private final Settings settings;
    private final DrawingApp drawingApp;

    public ButtonsOptions(DrawingApp drawingApp) {
        super();
        setLayout(new GridLayout(1, 2));
        add(eraseSegment = new EraseButton(drawingApp));
        listType = new ListType(drawingApp);
        settings = new Settings(drawingApp);

        this.drawingApp = drawingApp;
    }

    public void notifyForUpdate() {
        String curr = drawingApp.getDrawingAppModel().getCurrentForme();
        if (curr.equals(Constant.cst("CURSOR"))) {
            String type = drawingApp.getDrawingAppModel().getSelectionType();
            if (type == Constant.cst("SEGMENT")) {
                this.remove(listType);
                add(settings);
            } else {
                this.remove(settings);
                add(listType);
            }
        }
        eraseSegment.notifyForUpdate();
        listType.notifyForUpdate();
        settings.notifyForUpdate();
    }

    public void changeLocale() {
        eraseSegment.changeLocale();
        listType.changeLocale();
        settings.changeLocale();
    }
}