package view;

import javax.swing.*;

import resources.GlobalFont;

import java.awt.*;

public class InfoSeriePanel extends JPanel {
    private Image image;
    private JLabel imageSerie;
    private JLabel nameSerieLabel;
    private JLabel seasonSerieLabel;
    private JLabel chapsSerieLabel;
    private JLabel broadcastSerieLabel;
    private JLabel statusSerieLabel;
    private JLabel genresSerieLabel;

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

    private void initLabels(){
        imageSerie = new JLabel();
        imageSerie.setOpaque(true);
        imageSerie.setBackground(Color.white);
        nameSerieLabel = new JLabel("<html><center>Naruto narunate narutiimate hero 3: Finalmente un choque Jonin vs Genin indiscriminado, torneo de gran melee</center></html>");
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
        genresSerieLabel.setOpaque(true);
        genresSerieLabel.setBackground(Color.white);
        genresSerieLabel.setForeground(Color.white);
    }
    private void setFonts(){
        nameSerieLabel.setFont(GlobalFont.customFont);
        seasonSerieLabel.setFont(GlobalFont.infoFont);
        chapsSerieLabel.setFont(GlobalFont.infoFont);
        broadcastSerieLabel.setFont(GlobalFont.infoFont);
        statusSerieLabel.setFont(GlobalFont.infoFont);
        genresSerieLabel.setFont(GlobalFont.infoFont);
    }
    private void ubicateLabels(){
        imageSerie.setBounds(40, 40, 200, 300);
        nameSerieLabel.setBounds(280, 40, 717, 300);
        seasonSerieLabel.setBounds(40, 380, 200, 60);
        chapsSerieLabel.setBounds(40, 440, 200, 60);
        broadcastSerieLabel.setBounds(40, 500, 300, 60);
        statusSerieLabel.setBounds(40, 560, 200, 60);
        genresSerieLabel.setBounds(530, 380, 400, 300);
    }
    private void addLabels(){
        add(imageSerie);
        add(nameSerieLabel);
        add(seasonSerieLabel);
        add(chapsSerieLabel);
        add(broadcastSerieLabel);
        add(statusSerieLabel);
        add(genresSerieLabel);
    }
}
