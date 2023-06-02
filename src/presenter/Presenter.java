package presenter;

import fileOperations.Persistence;
import model.*;
import view.AddDialog;
import view.EditDialog;
import view.Frame;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Presenter implements ActionListener {
    private Frame frame;
    private NetflixAnime netflixAnime;
    private Persistence persistence;

    public Presenter() {
        persistence = new Persistence();
        frame = new Frame(this);
        netflixAnime = new NetflixAnime();
        loadData();
    }

    private void loadData() {
        netflixAnime.setUserList(persistence.getUserList());
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.start();
    }

    private void start() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand().toUpperCase()) {
            case "LOGIN_USER" -> loginUser();
            case "SIGN_USER" -> signUser();
            case "SERIE" -> showSerie(e);
            case "SHOW_ADD_DIALOG" -> showAddDialog();
            case "ADD_SERIE" -> addSerie();
            case "GO_TO_INFO" -> setInfoInInfoPanel();
            case "DELETE_SERIE" -> deleteSerie();
            case "SHOW_EDIT_DIALOG" -> showEditDialog();
            case "EDIT_ACCEPT" -> editSerie();
            case "SEARCH"-> searchSerie();
            case "ORDER_BY_NAME" -> orderByName();
            case "ORDER_BY_GENRE" -> orderByGenre();
            case "ORDER_BY_STATUS" -> orderByStatus();
            case "ORDER_BY_EMISSION" -> orderByEmission();
        }
    }

    private void orderByEmission() {
        try {
            String search = frame.getStringMessage("Ingrese el dia de emision").toUpperCase();
            BroadcastDay broadcastDay = BroadcastDay.valueOf(search);
            List<Serie> seriesMatch = netflixAnime.filterByBroadcastDay(broadcastDay);
            frame.getInfo().getListSeries().updateButtonList(seriesMatch);
        } catch (IllegalArgumentException e) {
            frame.showErrorMessage("No se encontro ese dia de emision");
            frame.getInfo().getListSeries().updateButtonList(netflixAnime.getActualUser().getUserSeriesList());
        }
    }

    private void orderByStatus() {
        try {
            String search = frame.getStringMessage("Ingrese el estado").toLowerCase();
            Status status = Status.valueOf(search.toUpperCase());
            List<Serie> seriesMatch = netflixAnime.filterByStatus(status);
            frame.getInfo().getListSeries().updateButtonList(seriesMatch);
        } catch (IllegalArgumentException e) {
            frame.showErrorMessage("No se encontro ese estado");
            frame.getInfo().getListSeries().updateButtonList(netflixAnime.getActualUser().getUserSeriesList());
        }
    }

    private void orderByGenre() {
        try {
            String genre = frame.getStringMessage("Ingrese el genero").toLowerCase();
            List<Serie> seriesMatch = netflixAnime.filterByGenre(genre);
            System.out.println(seriesMatch);
            frame.getInfo().getListSeries().updateButtonList(seriesMatch);
        } catch (Exception e) {
            frame.showErrorMessage("No se encontro ese genero");
            frame.getInfo().getListSeries().updateButtonList(netflixAnime.getActualUser().getUserSeriesList());
        }
    }

    private void orderByName() {
        List<Serie> seriesMatch = netflixAnime.sortAlphabetically();
        System.out.println(seriesMatch);
        frame.getInfo().getListSeries().updateButtonList(seriesMatch);
    }

    private void searchSerie() {
        String serieName = frame.getInfo().getButtonsPanel().getSearch().getText();
        List<Serie> seriesMatch = netflixAnime.searchAllSeries(serieName);
        if(serieName.equals("")){
            seriesMatch = netflixAnime.getActualUser().getUserSeriesList();
        }
        if (seriesMatch.isEmpty()) {
            frame.showErrorMessage("No se encontraron series con ese nombre");
        }
        frame.getInfo().getListSeries().updateButtonList(seriesMatch);
    }

    private void editSerie() {
        EditDialog editDialog = frame.getOptions().getEditDialog();
        Serie oldSerie = netflixAnime.getSerieToEdit();
        if (editDialog.getNameTextField().getText().isEmpty()) {
            frame.showErrorMessage("Debe ingresar el nombre de la serie");
            return;
        }
        if (editDialog.getSeasonsField().getText().isEmpty()) {
            frame.showErrorMessage("Debe ingresar la cantidad de temporadas");
            return;
        }
        if (editDialog.getChapsField().getText().isEmpty()) {
            frame.showErrorMessage("Debe ingresar la cantidad de capitulos");
            return;
        }
        Serie newSerie = getSerieFromEditDialog();
        netflixAnime.editSerie(oldSerie, newSerie);
        frame.getOptions().getEditDialog().setVisible(false);
        frame.showInfoMessage("Serie editada correctamente");
        saveData();
    }

    private Serie getSerieFromEditDialog() {
        Serie serie = new Serie();
        EditDialog dialog = frame.getOptions().getEditDialog();
        serie.setName(dialog.getNameTextField().getText());
        serie.setBroadcastDay(netflixAnime.toBroadcastDay(dialog.getBroadcastField().getSelectedItem().toString()));
        serie.setGenres(netflixAnime.toList(dialog.getGenresField().getText()));
        serie.setStatus(netflixAnime.toStatus(dialog.getStatusField().getSelectedItem().toString()));
        serie.setSeasons(Integer.parseInt(dialog.getSeasonsField().getText()));
        serie.setChapters(Integer.parseInt(dialog.getChapsField().getText()));
        serie.setDescription(dialog.getDescriptionArea().getText());
        return serie;
    }

    private void showEditDialog() {
        String serieName = frame.getStringMessage("Ingrese el nombre de la serie a editar");
        Serie serie = netflixAnime.searchSerie(serieName);
        if (serie == null) {
            frame.showErrorMessage("Serie no encontrada");
            return;
        }
        EditDialog editDialog = frame.getOptions().getEditDialog();
        editDialog.setLocationRelativeTo(frame);
        editDialog.clearFields();
        editDialog.fillComboBoxes(netflixAnime.getStatusList(), netflixAnime.getBroadcastDaysList());
        editDialog.fillInfo(serie);
        editDialog.setVisible(true);
        netflixAnime.setSerieToEdit(serie);
    }

    private void deleteSerie() {
        if (frame.getOptions().getDeleteDialog().getSerieNameText().getText().isEmpty()) {
            frame.showErrorMessage("Debe ingresar el nombre de la serie");
            return;
        }
        Serie serie = netflixAnime.searchSerie(frame.getOptions().getDeleteDialog().getSerieNameText().getText());
        if (serie == null) {
            frame.showErrorMessage("Serie no encontrada");
            return;
        }
        netflixAnime.deleteSerie(serie);
        frame.getOptions().getDeleteDialog().setVisible(false);
        frame.showInfoMessage("Serie eliminada correctamente");
        saveData();
    }

    private void showAddDialog() {
        AddDialog addDialog = frame.getOptions().getAddDialog();
        addDialog.clearFields();
        addDialog.setLocationRelativeTo(frame);
        addDialog.fillComboBoxes(netflixAnime.getStatusList(), netflixAnime.getBroadcastDaysList());
        addDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        addDialog.setVisible(true);
    }

    private void setInfoInInfoPanel() {
        frame.getInfo().loadSeries(netflixAnime.getActualUser().getUserSeriesList());
    }

    private void signUser() {
        String userName = frame.getInicio().getSignDialog().getNameTextField().getText();
        String password = frame.getInicio().getSignDialog().getPasswordField().getText();
        if (userName.isEmpty() || password.isEmpty()) {
            frame.showErrorMessage("Debe ingresar usuario y contraseña");
            return;
        }
        if (netflixAnime.searchUser(userName) != null) {
            frame.showErrorMessage("Usuario ya registrado");
            return;
        }
        frame.getInicio().getSignDialog().setVisible(false);
        netflixAnime.addUser(userName, password);
        frame.showInfoMessage("Usuario registrado correctamente");
    }

    private void loginUser() {
        String userName = frame.getInicio().getUserText().getText();
        String password = frame.getInicio().getPasswordText().getText();
        if (userName.isEmpty() || password.isEmpty()) {
            frame.showErrorMessage("Debe ingresar usuario y contraseña");
            return;
        }
        if (netflixAnime.searchUser(userName) == null) {
            frame.showErrorMessage("Usuario no registrado");
            return;
        }
        if (netflixAnime.validateLogin(userName, password)) {
            netflixAnime.setActualUser(netflixAnime.searchUser(userName));
            frame.showInfoMessage("Bienvenido " + userName);
            frame.showPanel(frame.getOptions());
        } else {
            frame.showErrorMessage("Usuario y/o contraseña incorrectos");
        }
    }

    private void showSerie(ActionEvent e) {
        JButton buttonPressed = (JButton) e.getSource();
        System.out.println(buttonPressed.getName());
        Serie serie = netflixAnime.searchSerie(buttonPressed.getName());
        frame.getInfo().getInfoSerie().loadSerie(serie);
    }

    private void addSerie() {
        netflixAnime.addSerie(createSerie());
        frame.showInfoMessage("Serie agregada correctamente");
        frame.getOptions().getAddDialog().setVisible(false);
        saveData();
    }

    private void saveData() {
        persistence.setUserList(netflixAnime.getUserList());
        persistence.saveData();
    }

    private Serie createSerie() {
        AddDialog dialog = frame.getOptions().getAddDialog();
        Serie serie = new Serie();
        serie.setName(dialog.getNameTextField().getText());
        serie.setBroadcastDay(netflixAnime.toBroadcastDay(dialog.getBroadcastField().getSelectedItem().toString()));
        serie.setGenres(netflixAnime.toList(dialog.getGenresField().getText()));
        serie.setStatus(netflixAnime.toStatus(dialog.getStatusField().getSelectedItem().toString()));
        serie.setSeasons(Integer.parseInt(dialog.getSeasonsField().getText()));
        serie.setChapters(Integer.parseInt(dialog.getChapsField().getText()));
        serie.setDescription(dialog.getDescriptionArea().getText());
        return serie;
    }
}