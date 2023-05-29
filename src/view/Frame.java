package view;

import javax.swing.*;

public class Frame extends JFrame {
    private PanelInicial inicio = new PanelInicial();
    private InfoPanel info = new InfoPanel();
    private OptionPanel options = new OptionPanel();

    public Frame(){
        super("Maneja tus series favoritas");
        setSize(1382, 768);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(info) ;
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
