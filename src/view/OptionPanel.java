package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OptionPanel extends JPanel{
    private Image image;
    private JButton goToInfo;
    private JButton goToAdd;
    private JButton goToDelete;
    private JButton goToBack;
    
    public OptionPanel(ActionListener actionListener){
        ImageIcon icon = new ImageIcon("src/resources/media/Fondo.jpg");
        Image originalImage = icon.getImage();
        Image scaledImage = originalImage.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImage).getImage();
        setVisible(true);
        setLayout(null);
        initButtons();
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
        goToDelete = new JButton("BORRAR");
        goToBack = new JButton("REGRESAR");
    }
    private void locateButtons(){
        goToInfo.setBounds(591, 105, 200, 80);
        goToAdd.setBounds(591, 270, 200, 80);
        goToDelete.setBounds(591, 435, 200, 80);
        goToBack.setBounds(591, 600, 200, 80);
    }
    private void addButtons(){
        add(goToInfo);
        add(goToAdd);
        add(goToDelete);
        add(goToBack);
    }
}
