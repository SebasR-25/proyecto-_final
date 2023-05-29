package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private final ActionListener actionListener;
    private PanelInicial inicio;
    private InfoPanel info;
    private OptionPanel options;

    public Frame(ActionListener actionListener) {
        super("Maneja tus series favoritas");
        this.actionListener = actionListener;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1382, 788);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponent(actionListener);
        getContentPane().add(inicio);
    }

    private void initComponent(ActionListener actionListener) {
        inicio = new PanelInicial(actionListener);
        info = new InfoPanel(actionListener);
        options = new OptionPanel(actionListener);
    }

    public PanelInicial getInicio() {
        return inicio;
    }

    public void setInicio(PanelInicial inicio) {
        this.inicio = inicio;
    }

    public InfoPanel getInfo() {
        return info;
    }

    public void setInfo(InfoPanel info) {
        this.info = info;
    }

    public OptionPanel getOptions() {
        return options;
    }

    public void setOptions(OptionPanel options) {
        this.options = options;
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, "<html><center>" + message + "</center></html>", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, "<html><center>" + message + "</center></html>", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
