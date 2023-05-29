package presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.*;
import fileOperations.*;

public class Presenter{
    FileWritter fw = new FileWritter();
    FileReadder fr = new FileReadder();
    ListManager manager = new ListManager();
    List<String> generos = new ArrayList<String>();
    public Presenter(){}

    private void addGen(){
        generos.add("terror");
        generos.add("comedia");
        generos.add("accion");
    }
    private void addSeries(){
        Serie serie1 = new Serie("Anime1", generos, Status.ACTIVA, 2, 1, 24, "cualquier cosa que se pueda leer", BroadcastDay.DOMINGO);
        Serie serie2 = new Serie("Anime2", generos, Status.ACTIVA, 2, 2, 24, "cualquier cosa que se pueda leer", BroadcastDay.DOMINGO);
        Serie serie3 = new Serie("Anime3", generos, Status.ACTIVA, 2, 3, 24, "cualquier cosa que se pueda leer", BroadcastDay.DOMINGO);
        Serie serie4 = new Serie("Anime4", generos, Status.EN_ESPERA, 1, 4, 0, "Nueva serie ingresada", BroadcastDay.MIERCOLES);
        manager.addSerie(serie1);
        manager.addSerie(serie2);
        manager.addSerie(serie3);
        manager.addSerie(serie4);
    }
    private String toJSON(){
        String temp = "[";
        int i  = 0;
        for (Serie serie : manager.getSeriesList()) {
            if (i == manager.getSeriesList().size()-1) {
                temp +=  fw.getJson(serie);
            } else {
                temp +=  fw.getJson(serie) + ",";
                i++;
            }
        }
        temp += "]";
        return temp;
    }
    private void writeJSON() throws IOException{
        fw.write(toJSON());
    }
    private void readJSON() throws FileNotFoundException, IOException{
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