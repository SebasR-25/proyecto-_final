package view;

import java.awt.Color;

import javax.swing.*;

public class InfoPanel extends JPanel {
    private InfoSeriePanel infoSerie;
    private ListSeriesPanel listSeries;
    private ButtonsInfoPanel buttonsPanel;
    private JScrollPane scroll;

    public InfoPanel(){
        setVisible(true);
        setLayout(null);
        initPanels();
        addPanels();
    }

    //1382, 784
    private void initPanels(){
        infoSerie = new InfoSeriePanel();
        listSeries = new ListSeriesPanel();
        buttonsPanel = new ButtonsInfoPanel();
        scroll = new JScrollPane();
        buttonsPanel.setBounds(0, 0, 345, 392);
        infoSerie.setBounds(345 ,0, 1037, 768);
        scroll.setBounds(0, 392, 345, 355);
    }
    private void addPanels(){
        scroll.setViewportView(listSeries);
        add(scroll);
        add(buttonsPanel);
        add(infoSerie);
    }
}
