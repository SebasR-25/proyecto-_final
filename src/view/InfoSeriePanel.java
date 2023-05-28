package view;

import javax.swing.*;
import java.awt.*;

public class InfoSeriePanel extends JPanel {
    private Image image;
    private JLabel imageSerie;
    private JLabel nameSerieLabel;
    private JLabel seasonSerieLabel;
    private JLabel chapsSerieLabel;
    private JLabel broadcastSerieLabel;
    private JLabel genresSerieLabel;

    public InfoSeriePanel() {
        ImageIcon icon = new ImageIcon("src/resources/media/Fondo2.jpg");
        Image originalImage = icon.getImage();
        image = new ImageIcon(originalImage).getImage();
        setVisible(true);
        setLayout(null);
        setBackground(Color.black);
        initLabels();
        ubicateLabels();
        addLabels();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, -245, 0, 1382, 745, this);
    }

    private void initLabels(){
        imageSerie = new JLabel();
        nameSerieLabel = new JLabel();
        nameSerieLabel.setForeground(Color.white);
        seasonSerieLabel = new JLabel("Temporadas:");
        seasonSerieLabel.setForeground(Color.white);
        chapsSerieLabel = new JLabel("Capítulos:");
        chapsSerieLabel.setForeground(Color.white);
        broadcastSerieLabel = new JLabel("Día de Emisión:");
        broadcastSerieLabel.setForeground(Color.white);
        genresSerieLabel = new JLabel("Géneros:");
    }
    private void ubicateLabels(){
        imageSerie.setBounds(40, 40, 100, 300);
        nameSerieLabel.setBounds(180, 40, 817, 300);
        seasonSerieLabel.setBounds(40, 380, 400, 60);
        chapsSerieLabel.setBounds(40, 440, 400, 60);
        broadcastSerieLabel.setBounds(40, 500, 400, 60);

    }
    private void addLabels(){
        add(imageSerie);
        add(nameSerieLabel);
        add(seasonSerieLabel);
        add(chapsSerieLabel);
        add(broadcastSerieLabel);
    }
}
