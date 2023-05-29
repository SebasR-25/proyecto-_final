package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel {
    private InfoSeriePanel infoSerie;
    private ListSeriesPanel listSeries;
    private ButtonsInfoPanel buttonsPanel;

    public InfoPanel(ActionListener actionListener){
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
        infoSerie.setBounds(345 ,0, 1037, 768);
        listSeries.setBounds(0, 392, 345, 392);
        buttonsPanel.setBounds(0, 0, 345, 392);
    }
    private void addPanels(){
        add(buttonsPanel);
        add(listSeries);
        add(infoSerie);
    }
}
