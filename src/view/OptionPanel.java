package view;

import javax.swing.*;

import resources.GlobalFont;

import java.awt.*;

public class OptionPanel extends JPanel{
    private Image image;
    private JButton goToInfo;
    private JButton goToAdd;
    private JButton goToEdit;
    private JButton goToDelete;
    private JButton goToBack;
    
    public OptionPanel(){
        ImageIcon icon = new ImageIcon("src/resources/media/Fondo.jpg");
        Image originalImage = icon.getImage();
        Image scaledImage = originalImage.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImage).getImage();
        setVisible(true);
        setLayout(null);
        initButtons();
        addFont();
        locateButtons();
        addButtons();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 1366, 768, this);
    }

    private void initButtons(){
        goToInfo = new JButton("VER SERIES");
        goToAdd = new JButton("AÑADIR");
        goToEdit = new JButton("EDITAR");
        goToDelete = new JButton("BORRAR");
        goToBack = new JButton("REGRESAR");
    }
    private void addFont(){
        goToInfo.setFont(GlobalFont.infoFont);
        goToAdd.setFont(GlobalFont.infoFont);
        goToEdit.setFont(GlobalFont.infoFont);
        goToDelete.setFont(GlobalFont.infoFont);
        goToBack.setFont(GlobalFont.infoFont);
    }
    private void locateButtons(){
        goToInfo.setBounds(591, 61, 200, 80);
        goToAdd.setBounds(591, 202, 200, 80);
        goToEdit.setBounds(591, 343, 200, 80);
        goToDelete.setBounds(591, 484, 200, 80);
        goToBack.setBounds(591, 625, 200, 80);
    }
    private void addButtons(){
        add(goToInfo);
        add(goToAdd);
        add(goToEdit);
        add(goToDelete);
        add(goToBack);
    }
}
