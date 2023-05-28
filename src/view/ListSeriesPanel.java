package view;

import javax.swing.*;

import resources.GlobalFont;

import java.awt.*;

public class ListSeriesPanel extends JPanel{
    private  JLabel listLabel;

    public ListSeriesPanel(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(5, 5, 21));
        label();
        addButtons();
    }
    private void label(){
        listLabel = new JLabel("<html><center>LISTA DE SERIES</center></html>");
        listLabel.setSize(345, 30);
        listLabel.setFont(GlobalFont.infoFont);
        listLabel.setHorizontalAlignment(SwingConstants.CENTER);
        listLabel.setForeground(Color.white);
        add(listLabel);
    }
    private void addButtons(){
        for (int i = 0; i < 20; i++) {
            JButton tempButton = new JButton("Boton " + i);
            tempButton.setSize(345, 50);
            add(tempButton);
        }
    }
}
