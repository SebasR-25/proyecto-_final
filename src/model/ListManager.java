package model;

import java.util.ArrayList;
import java.util.List;

public class ListManager {
    private List<Serie> seriesList = new ArrayList<>();

    public ListManager() {}
    public ListManager(List<Serie> seriesList) {
        this.seriesList = seriesList;
    }
    public List<Serie> getSeriesList() {
        return seriesList;
    }
    public void setSeriesList(List<Serie> seriesList) {
        this.seriesList = seriesList;
    }
    public List<Serie> sortByBroadcastDay(){
        List<Serie> tempList = new ArrayList<>();
        return tempList;
    }
    public List<Serie> sortByStatus(){
        List<Serie> tempList = new ArrayList<>();
        return tempList;
    }
    public List<Serie> sortByGenres(){
        List<Serie> tempList = new ArrayList<>();
        return tempList;
    }
    public List<Serie> sortAlphabetically(){
        List<Serie> tempList = new ArrayList<>();
        return tempList;
    }
    public void addSerie(Serie serie){
        seriesList.add(serie);
    }
    public String editSerie(int id, Serie serie){
        String message = "";
        for (Serie temptSerie : seriesList) {
            if (serie.getId() == id) {
                seriesList.remove(temptSerie);
                seriesList.add(serie);
                message = "Se añadió la nueva serie";
            }else{
                message = "No se pudo encontrar la serie especificada";
            }
        }
        return message;
    }
    public String deleteSerie(int id){
        String message = "";
        for (Serie serie : seriesList) {
            if (serie.getId() == id) {
                seriesList.remove(serie);
                message = "Se eliminó la seie de la lista";
            }else{
                message = "No se pudo encontrar la serie";
            }
        }
        return message;
    }
    public String toStringSerie(Serie serie){
        String message = "Nombre: " + serie.getName() + "\nGéneros: " + serie.toStringGenres() +"\nEstado: " + serie.getStatus() + "\nTemporadas: " + serie.getSeasons() + "\nID: " + serie.getId() + "\nCapítulos: " + serie.getChapters() + "\nDescripsión: " + serie.getDescription() + "\nDía de emisión: " + serie.getBroadcastDay();
        return message;
    }
    public String toStringList(List<Serie> lista){
        String message = "";
        for (int i = 0; i < lista.size(); i++) {
            message += toStringSerie(lista.get(i)) + "\n";
        }
        return message;
    }
}
