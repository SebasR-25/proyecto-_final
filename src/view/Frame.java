package view;

import javax.swing.*;

public class Frame extends JFrame {
    private PanelInicial inicio = new PanelInicial();
    private InfoPanel info = new InfoPanel();
    private OptionPanel options = new OptionPanel();

    public Frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1382, 768);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Maneja tus series favoritas");
        getContentPane().add(options);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
