package model;

import java.util.ArrayList;
import java.util.List;

public class NetflixAnime {
    private List<Serie> seriesList;
    private List<User> userList;
    private List<String> genereList;

    public NetflixAnime() {
        seriesList = new ArrayList<>();
        userList = new ArrayList<>();
        genereList = new ArrayList<>();
    }

    public NetflixAnime(List<Serie> seriesList, List<User> userList, List<String> genereList) {
        this.seriesList = seriesList;
        this.userList = userList;
        this.genereList = genereList;
    }

    public List<Serie> filterByBroadcastDay(BroadcastDay broadcastDay) {
        List<Serie> filteredList = new ArrayList<>();
        for (Serie serie : seriesList) {
            if (serie.getBroadcastDay().equals(broadcastDay)) {
                filteredList.add(serie);
            }
        }
        return filteredList;
    }

    public List<Serie> filterByStatus(Status status) {
        List<Serie> filteredList = new ArrayList<>();
        for (Serie serie : seriesList) {
            if (serie.getStatus().equals(status)) {
                filteredList.add(serie);
            }
        }
        return filteredList;
    }

    public List<Serie> filterByGenre(String genre) {
        List<Serie> filteredList = new ArrayList<>();
        for (Serie serie : seriesList) {
            if (serie.getGenres().contains(genre)) {
                filteredList.add(serie);
            }
        }
        return filteredList;
    }

    public List<Serie> sortAlphabetically() {
        seriesList.sort((serie1, serie2) -> serie1.getName().compareTo(serie2.getName()));
        return seriesList;
    }

    public void addSerie(Serie serie) {
        seriesList.add(serie);
    }

    public Serie searchSerie(int id) {
        for (Serie temptSerie : seriesList) {
            if (temptSerie.getId() == id) {
                return temptSerie;
            }
        }
        return null;
    }

    public void editSerie(Serie oldSerie, Serie newSerie) {
        seriesList.remove(oldSerie);
        seriesList.add(newSerie);
    }

    public void deleteSerie(Serie serie) {
        seriesList.remove(serie);
    }

    public String toStringSerie(Serie serie) {
        String message = "Nombre: " + serie.getName() + "\nGéneros: " + serie.toStringGenres() + "\nEstado: " + serie.getStatus() + "\nTemporadas: " + serie.getSeasons() + "\nID: " + serie.getId() + "\nCapítulos: " + serie.getChapters() + "\nDescripsión: " + serie.getDescription() + "\nDía de emisión: " + serie.getBroadcastDay();
        return message;
    }

    public String toStringList(List<Serie> lista) {
        String message = "";
        for (int i = 0; i < lista.size(); i++) {
            message += toStringSerie(lista.get(i)) + "\n";
        }
        return message;
    }

    public List<Serie> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Serie> seriesList) {
        this.seriesList = seriesList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<String> getGenereList() {
        return genereList;
    }

    public void setGenereList(List<String> genereList) {
        this.genereList = genereList;
    }

    public boolean validateLogin(String userName, String password) {
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User searchUser(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
