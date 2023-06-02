package view;

import javax.swing.*;

import model.Serie;
import resources.GlobalFont;

import java.awt.*;
import java.util.List;

public class InfoSeriePanel extends JPanel {
    private Image image;
    private JLabel imageSerie;
    private JLabel nameSerieLabel;
    private JLabel seasonSerieLabel;
    private JLabel chapsSerieLabel;
    private JLabel broadcastSerieLabel;
    private JLabel statusSerieLabel;
    private JLabel genresSerieLabel;
    private JLabel description;

    public InfoSeriePanel() {
        ImageIcon icon = new ImageIcon("src/resources/media/Fondo2.jpg");
        Image originalImage = icon.getImage();
        image = new ImageIcon(originalImage).getImage();
        setVisible(true);
        setLayout(null);
        setBackground(Color.black);
        initLabels();
        setFonts();
        ubicateLabels();
        addLabels();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, -245, 0, 1382, 745, this);
    }

    private void initLabels() {
        imageSerie = new JLabel();
        imageSerie.setOpaque(true);
        imageSerie.setBackground(Color.white);
        nameSerieLabel = new JLabel("<html><center></center></html>");
        nameSerieLabel.setForeground(Color.white);
        seasonSerieLabel = new JLabel("Temporadas:");
        seasonSerieLabel.setForeground(Color.white);
        chapsSerieLabel = new JLabel("Capítulos:");
        chapsSerieLabel.setForeground(Color.white);
        broadcastSerieLabel = new JLabel("Día de Emisión:");
        broadcastSerieLabel.setForeground(Color.white);
        statusSerieLabel = new JLabel("Estado:");
        statusSerieLabel.setForeground(Color.white);
        genresSerieLabel = new JLabel("Géneros:");
        genresSerieLabel.setVerticalAlignment(SwingConstants.TOP);
        genresSerieLabel.setForeground(Color.white);
        description = new JLabel("Descrpción:");
        description.setVerticalAlignment(SwingConstants.TOP);
        description.setForeground(Color.white);
    }

    private void setFonts() {
        nameSerieLabel.setFont(GlobalFont.customFont);
        seasonSerieLabel.setFont(GlobalFont.infoFont);
        chapsSerieLabel.setFont(GlobalFont.infoFont);
        broadcastSerieLabel.setFont(GlobalFont.infoFont);
        statusSerieLabel.setFont(GlobalFont.infoFont);
        genresSerieLabel.setFont(GlobalFont.infoFont);
        description.setFont(GlobalFont.infoFontReduced);
    }

    private void ubicateLabels() {
        imageSerie.setBounds(40, 40, 200, 300);
        nameSerieLabel.setBounds(280, 40, 717, 300);
        seasonSerieLabel.setBounds(40, 360, 200, 60);
        chapsSerieLabel.setBounds(40, 420, 200, 60);
        broadcastSerieLabel.setBounds(40, 480, 300, 60);
        statusSerieLabel.setBounds(40, 540, 200, 60);
        genresSerieLabel.setBounds(40, 600, 400, 120);
        description.setBounds(530, 380, 400, 350);
    }

    private void addLabels() {
        add(imageSerie);
        add(nameSerieLabel);
        add(seasonSerieLabel);
        add(chapsSerieLabel);
        add(broadcastSerieLabel);
        add(statusSerieLabel);
        add(genresSerieLabel);
        add(description);
    }

    public void loadSerie(Serie serie) {
        nameSerieLabel.setText("<html><center>" + serie.getName() + "</center></html>");
        seasonSerieLabel.setText("Temporadas: " + serie.getSeasons());
        chapsSerieLabel.setText("Capítulos: " + serie.getChapters());
        broadcastSerieLabel.setText("Día de Emisión: " + serie.getBroadcastDay());
        statusSerieLabel.setText("Estado: " + serie.getStatus());
        genresSerieLabel.setText("<html> Géneros: " + adaptList(serie.getGenres()) + "</html>");
        description.setText("<html><center> Description: " + serie.getDescription() + "</center></html>");
    }

    private String adaptList(List<String> genres) {
        StringBuilder result = new StringBuilder();
        for (String genre : genres) {
            result.append(genre).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }
}
