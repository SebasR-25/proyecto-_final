package view;

import model.Serie;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class InfoPanel extends JPanel {
    private ActionListener actionListener;
    private InfoSeriePanel infoSerie;
    private ListSeriesPanel listSeries;
    private ButtonsInfoPanel buttonsPanel;
    private JScrollPane scroll;

    public InfoPanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        setVisible(true);
        setLayout(null);
        initPanels(actionListener);
        addPanels();
    }

    private void initPanels(ActionListener actionListener) {
        infoSerie = new InfoSeriePanel();
        buttonsPanel = new ButtonsInfoPanel(actionListener);
        scroll = new JScrollPane();
        buttonsPanel.setBounds(0, 0, 345, 392);
        infoSerie.setBounds(345, 0, 1037, 768);
        scroll.setBounds(0, 392, 345, 355);
    }

    private void addPanels() {
        scroll.setViewportView(listSeries);
        add(scroll);
        add(buttonsPanel);
        add(infoSerie);
    }

    public InfoSeriePanel getInfoSerie() {
        return infoSerie;
    }

    public ListSeriesPanel getListSeries() {
        return listSeries;
    }

    public ButtonsInfoPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void loadSeries(List<Serie> userSeriesList) {
        listSeries = new ListSeriesPanel(userSeriesList, actionListener);
        scroll.setViewportView(listSeries);
    }
}
