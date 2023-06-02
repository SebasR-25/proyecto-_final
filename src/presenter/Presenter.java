package presenter;

import fileOperations.Persistence;
import model.*;
import view.AddDialog;
import view.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        }
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
        /*
         *Serie serie = netflixAnime.searchSerie();
        if (serie == null) {
            frame.showErrorMessage("Serie no encontrada");
            return;
        } 
         */

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
        AddDialog addDialog = frame.getOptions().getAddDialog();
        Serie serie = new Serie();
        serie.setName(addDialog.getNameTextField().getText());
        serie.setBroadcastDay(netflixAnime.toBroadcastDay(addDialog.getBroadcastField().getSelectedItem().toString()));
        serie.setGenres(netflixAnime.toList(addDialog.getGenresField().getText()));
        serie.setStatus(netflixAnime.toStatus(addDialog.getStatusField().getSelectedItem().toString()));
        serie.setSeasons(Integer.parseInt(addDialog.getSeasonsField().getText()));
        serie.setChapters(Integer.parseInt(addDialog.getChapsField().getText()));
        serie.setDescription(addDialog.getDescriptionArea().getText());
        return serie;
    }
}