package view;

import javax.swing.*;
import resources.GlobalFont;
import java.awt.*;
import model.Serie;
import java.util.List;

public class ListSeriesPanel extends JPanel {

    public ListSeriesPanel(List<Serie> series) {
        setVisible(true);
        setLayout(new GridBagLayout());
        setBackground(new Color(5, 5, 21));
        addTitleLabel();
        addButtons(series);
    }

    private void addTitleLabel() {
        JLabel listLabel = new JLabel("<html><center>LISTA DE SERIES</center></html>");
        listLabel.setFont(GlobalFont.infoFont);
        listLabel.setForeground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(listLabel, gbc);
    }

    private void addButtons(List<Serie> series) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (int i = 0; i < series.size(); i++) {
            gbc.gridy++;
            JButton tempButton = new JButton("<html><center>" + adaptToHtml(series.get(i).getName()) + "</center></html>");
            tempButton.setSize(345, 50);
            add(tempButton, gbc);
        }
    }

    private String adaptToHtml(String text) {
        String html = "<br>";
        StringBuilder builder = new StringBuilder(text);
        int upperLimit = 41;
        if (builder.length() > upperLimit) {
            int i = upperLimit;
            if (builder.charAt(upperLimit) != ' ') {
                while (builder.charAt(i) != ' ') {
                    i--;
                }
            }
            while (i < builder.length()) {
                if (builder.charAt(i) == ' '||i == builder.length() - 1) {
                    builder.insert(i, html);
                    i += upperLimit;
                } else {
                    i++;
                }
            }
        }
        return builder.toString();
    }
}
