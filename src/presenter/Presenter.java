package presenter;

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

    public Presenter() {
        frame = new Frame();
        netflixAnime = new NetflixAnime();
        loadDefaultData();
    }

    private void loadDefaultData() {
        loadUsers();
        loadGenres();
        loadSeries();
    }

    private void loadUsers() {

    }

    private void loadGenres() {

    }

    private void loadSeries() {

    }

    private String toJSON() {
        String temp = "[";
        int i = 0;
        for (Serie serie : netflixAnime.getSeriesList()) {
            if (i == netflixAnime.getSeriesList().size() - 1) {
                temp += fw.getJson(serie);
            } else {
                temp += fw.getJson(serie) + ",";
                i++;
            }
        }
        temp += "]";
        return temp;
    }

    private void writeJSON() throws IOException {
        fw.write(toJSON());
    }

    private void readJSON() throws FileNotFoundException, IOException {
        fr.loadFileJson();
        List<Serie> temp = fr.getSeries();
        System.out.println(temp.size() + "");
    }

    public static void main(String[] args) throws IOException {
        Presenter p = new Presenter();
        p.addGen();
        p.addSeries();
        p.toJSON();
        p.writeJSON();
        p.readJSON();
    }
}