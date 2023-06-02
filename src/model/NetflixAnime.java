package model;

import java.util.ArrayList;
import java.util.List;

public class NetflixAnime {
    private List<User> userList;
    private User actualUser;
    private Serie serieToEdit;
    public NetflixAnime() {
        userList = new ArrayList<>();
    }

    public NetflixAnime(List<User> userList) {
        this.userList = userList;
    }

    public List<Serie> filterByBroadcastDay(BroadcastDay broadcastDay) {
        List<Serie> filteredList = new ArrayList<>();
        List<Serie> seriesList = actualUser.getUserSeriesList();
        for (Serie serie : seriesList) {
            if (serie.getBroadcastDay().equals(broadcastDay)) {
                filteredList.add(serie);
            }
        }
        return filteredList;
    }

    public List<Serie> filterByStatus(Status status) {
        List<Serie> filteredList = new ArrayList<>();
        List<Serie> seriesList = actualUser.getUserSeriesList();
        for (Serie serie : seriesList) {
            if (serie.getStatus().equals(status)) {
                filteredList.add(serie);
            }
        }
        return filteredList;
    }

    public List<Serie> filterByGenre(String genre) {
        List<Serie> filteredList = new ArrayList<>();
        List<Serie> seriesList = actualUser.getUserSeriesList();
        for (Serie serie : seriesList) {
            if (serie.getGenres().contains(genre)) {
                filteredList.add(serie);
            }
        }
        return filteredList;
    }

    public List<Serie> sortAlphabetically() {
        List<Serie> seriesList = actualUser.getUserSeriesList();
        seriesList.sort((serie1, serie2) -> serie1.getName().compareTo(serie2.getName()));
        return seriesList;
    }

    public void addSerie(Serie serie) {
        actualUser.getUserSeriesList().add(serie);
    }

    public Serie searchSerie(String serieName) {
        List<Serie> seriesList = actualUser.getUserSeriesList();
        for (Serie temptSerie : seriesList) {
            if (temptSerie.getName().equals(serieName)) {
                return temptSerie;
            }
        }
        return null;
    }

    public void editSerie(Serie oldSerie, Serie newSerie) {
        List<Serie> seriesList = actualUser.getUserSeriesList();
        seriesList.remove(oldSerie);
        seriesList.add(newSerie);
    }

    public void deleteSerie(Serie serie) {
        actualUser.getUserSeriesList().remove(serie);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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

    public void addUser(String userName, String password) {
        userList.add(new User(userName, password,new ArrayList<>()));
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }
    public List<String> toList(String str){
        List<String> list = new ArrayList<>();
        String[] array = str.split(", ");
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    public Status toStatus(String str){
        Status status = null;
        switch (str.toUpperCase()) {
            case "ACTIVA":
                status = Status.ACTIVA;
                break;
            case "EN_ESPERA":
                status = Status.EN_ESPERA;
                break;
            case "INACTIVA":
                status = Status.INACTIVA;
                break;
        }
        return status;
    }
    public BroadcastDay toBroadcastDay(String str){
        BroadcastDay broadcastDay = switch (str.toUpperCase()) {
            case "LUNES" -> BroadcastDay.LUNES;
            case "MARTES" -> BroadcastDay.MARTES;
            case "MIERCOLES" -> BroadcastDay.MIERCOLES;
            case "JUEVES" -> BroadcastDay.JUEVES;
            case "VIERNES" -> BroadcastDay.VIERNES;
            case "SABADO" -> BroadcastDay.SABADO;
            case "DOMINGO" -> BroadcastDay.DOMINGO;
            default -> null;
        };
        return broadcastDay;
    }

    public List<Status> getStatusList() {
        List<Status> statusList = new ArrayList<>();
        statusList.add(Status.ACTIVA);
        statusList.add(Status.EN_ESPERA);
        statusList.add(Status.INACTIVA);
        return statusList;
    }

    public List<BroadcastDay> getBroadcastDaysList() {
        List<BroadcastDay> broadcastDaysList = new ArrayList<>();
        broadcastDaysList.add(BroadcastDay.LUNES);
        broadcastDaysList.add(BroadcastDay.MARTES);
        broadcastDaysList.add(BroadcastDay.MIERCOLES);
        broadcastDaysList.add(BroadcastDay.JUEVES);
        broadcastDaysList.add(BroadcastDay.VIERNES);
        broadcastDaysList.add(BroadcastDay.SABADO);
        broadcastDaysList.add(BroadcastDay.DOMINGO);
        return broadcastDaysList;
    }

    public Serie getSerieToEdit() {
        return serieToEdit;
    }

    public void setSerieToEdit(Serie serieToEdit) {
        this.serieToEdit = serieToEdit;
    }
}
