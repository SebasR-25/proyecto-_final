package view;

import javax.swing.*;

public class Frame extends JFrame {
    private PanelInicial inicio = new PanelInicial();
    private InfoPanel info = new InfoPanel();
    private OptionPanel options = new OptionPanel();

    public Frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1382, 788);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Maneja tus series favoritas");
        getContentPane().add(inicio) ;
    }

    public static void main(String[] args) {
        new Frame();
    }
}
