package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonsInfoPanel extends JPanel {
    private ActionListener actionListener;
    private JButton back;
    private JLabel orderLabel;
    private JButton namesButton;
    private JButton genreButton; 
    private JButton statusButton;
    private JButton emisionButton;
    private JTextField search;
    private JButton searchButton;

    public ButtonsInfoPanel(ActionListener actionListener){
        this.actionListener = actionListener;
        setVisible(true);
        setLayout(null);
        setBackground(new Color(0, 13, 26));
        initComp(); 
        addComp();  
    }

    private void initComp(){
        label();
        initButtons();
        searchComp();
    }
    private void addComp(){
        add(orderLabel);
        addButtons();
        addSearchComp();
    }
    private void label(){
        orderLabel = new JLabel("Ordenar por:");
        orderLabel.setOpaque(true);
        orderLabel.setBackground(new Color(0,0,0,0));
        orderLabel.setForeground(Color.white);
        orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderLabel.setBounds(0, 0, 345, 65);
    }
    private void initButtons(){
        Image icon = new ImageIcon("src/resources/media/back-icon.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        back = new JButton(new ImageIcon(icon));
        namesButton = new JButton("NOMBRE");
        genreButton = new JButton("GÉNERO");
        statusButton = new JButton("ESTADO");
        emisionButton = new JButton("EMISIÓN");
        locateButtons();
    }
    private void addButtons(){
        add(back);
        add(namesButton);
        add(genreButton);
        add(statusButton);
        add(emisionButton);
    }
    private void locateButtons(){
        back.setBounds(10, 10, 30, 30);
        namesButton.setBounds(118, 85, 105, 25);
        genreButton.setBounds(118, 145, 105, 25);
        statusButton.setBounds(118, 205, 105, 25);
        emisionButton.setBounds(118, 265, 105, 25);
    }
    private void searchComp(){
        search = new JTextField("Buscar");
        searchButton = new JButton();
        search.setBounds(118, 325, 85, 25);
        searchButton.setBounds(202, 325, 25, 25);
        searchButton.setIcon(new ImageIcon("src/resources/media/buscar.png"));
    }
    private void addSearchComp(){
        add(search);
        add(searchButton);
    }

    public JButton getBack() {
        return back;
    }
    
}
