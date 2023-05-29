package presenter;

import fileOperations.Persistence;
import model.BroadcastDay;
import model.NetflixAnime;
import model.Serie;
import model.Status;
import view.Frame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private Frame frame;
    private NetflixAnime netflixAnime;
    private Persistence persistence;

    public Presenter() {
        persistence = new Persistence();
        frame = new Frame();
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
}