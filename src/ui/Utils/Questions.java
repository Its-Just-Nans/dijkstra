package ui.Utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Questions {
    public static int ask(String text, int defaultValue, int minValue, int maxValue) {
        String response = "";
        response = JOptionPane.showInputDialog(text + " (entre " + minValue + " et " + maxValue + ")");
        int value = defaultValue;
        try {
            if (response.equals("") || response == null) {
                value = defaultValue;
            } else {
                value = Integer.parseInt(response);
            }
        } catch (final NumberFormatException e) {
            value = defaultValue; // rare case when input is void
        }
        if (value < minValue || value > maxValue) {
            value = defaultValue;
            JFrame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Mauvaise valeur. Choix par défault " + defaultValue);
        }
        return value;
    }
}
