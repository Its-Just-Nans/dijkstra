package ui.Utils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ui.Drawing.DrawingApp;

public class Modal {
    private static int checkValue(String val, int minValue, int maxValue, int defaultValue) {
        int finalValue = defaultValue;
        try {
            if (val == null || val.equals("")) {
                finalValue = defaultValue;
            } else {
                finalValue = Integer.parseInt(val);
            }
        } catch (final NumberFormatException e) {
            finalValue = defaultValue; // rare case when input is void
        }
        if (finalValue < minValue || finalValue > maxValue) {
            finalValue = defaultValue;
            JFrame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, Constant.t("ERR_MSG_INPUT") + defaultValue);
        }
        return finalValue;
    }

    public static int ask(String text, int defaultValue, int minValue, int maxValue) {
        String response = "";
        response = JOptionPane.showInputDialog(text + " (entre " + minValue + " et " + maxValue + ")", defaultValue);
        int value = checkValue(response, minValue, maxValue, defaultValue);
        return value;
    }

    public static void showOptions(DrawingApp drawingApp) {
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

        int squareSize = drawingApp.getDrawingAppModelLaby().getSquareSize();
        JTextField xField = new JTextField(String.valueOf(squareSize));

        JRadioButton lang_fr = new JRadioButton("Français");
        JRadioButton lang_en = new JRadioButton("English");
        if (Constant.lang.equals("fr")) {
            lang_fr.setSelected(true);
        } else {
            lang_en.setSelected(true);
        }
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(lang_fr);
        bgroup.add(lang_en);

        myPanel.add(lang_fr);
        myPanel.add(lang_en);
        myPanel.add(new JLabel(Constant.t("SQUARE_SIZE")));
        myPanel.add(xField);

        JOptionPane.showMessageDialog(null, myPanel,
                Constant.t("OPTIONS"), JOptionPane.OK_CANCEL_OPTION);
        int correctNewValue = checkValue(xField.getText(), 5, 100, 20);
        if (correctNewValue != squareSize) {
            drawingApp.getDrawingAppModelLaby().setSquareSize(correctNewValue);
            makeMessage(Constant.t("OPT_MOD"));
        }
        if (lang_en.isSelected()) {
            Constant.changeLang("en");
        } else {
            Constant.changeLang("fr");
        }
        drawingApp.changeLocale();
    }

    public static void makeMessage(String msg) {
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(msg);
        label.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        myPanel.add(label);
        JOptionPane.showMessageDialog(null, myPanel,
                "Informations", JOptionPane.OK_CANCEL_OPTION);
    }

    public static void showAbout() {
        String link = "https://n4n5.dev";
        final String[] strings = {
                "INF103 (Java @ Télécom Paris)",
                "Made by n4n5",
                "2022"
        };
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        for (String oneStr : strings) {
            JLabel label = new JLabel(oneStr);
            label.setAlignmentX(JPanel.CENTER_ALIGNMENT);
            myPanel.add(label);
        }
        JLabel hyperlink = new JLabel(link);
        hyperlink.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        hyperlink.setForeground(Color.BLUE);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        hyperlink.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(link));
                } catch (IOException | URISyntaxException e1) {
                    // e1.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setForeground(Color.BLUE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setForeground(Color.RED);
            }

        });
        myPanel.add(hyperlink);

        JOptionPane.showMessageDialog(null, myPanel,
                "Informations", JOptionPane.OK_CANCEL_OPTION);
    }

    public static boolean showYesOrNo(String title, String msg) {
        int response = JOptionPane.showInternalOptionDialog(null,
                msg,
                title,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, null, null);
        switch (response) {
            case JOptionPane.OK_OPTION:
                return true;
            case JOptionPane.CANCEL_OPTION: // will take the default
            default:
                return false;
        }
    }
}
