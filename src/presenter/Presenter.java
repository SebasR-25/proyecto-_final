package presenter;

import java.util.ArrayList;
import java.util.List;
import fileOperations.Persistence;
import model.*;
import view.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

    public class Presenter implements ActionListener {
    private Frame frame;
    private NetflixAnime netflixAnime;
    private Persistence persistence;
    List<String> generos = new ArrayList<String>();
    
    public Presenter() {
        persistence = new Persistence();
        frame = new Frame(this);
        netflixAnime = new NetflixAnime();
        loadDefaultData();
    }

    private void loadDefaultData() {
        netflixAnime.setUserList(persistence.getUserList());
        netflixAnime.setGenereList(persistence.getGenereList());
        netflixAnime.setSeriesList(persistence.getSeriesList());
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
        switch (e.getActionCommand().toUpperCase()) {
            case "LOGIN_USER" -> loginUser();
            case "SIGN_USER" -> signUser();
        }
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
            frame.showInfoMessage("Bienvenido " + userName);
            frame.showPanel(frame.getOptions());
        } else {
            frame.showErrorMessage("Usuario y/o contraseña incorrectos");
        }
    }
}