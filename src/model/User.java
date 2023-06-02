package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private List<Serie> userSeriesList;

    public User() {
        userName = "";
        password = "";
        userSeriesList = new ArrayList<>();
    }

    public User(String userName, String password, List<Serie> userSeriesList) {
        this.userName = userName;
        this.password = password;
        this.userSeriesList = userSeriesList;
    }

    public void addSerie(Serie serie) {
        userSeriesList.add(serie);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Serie> getUserSeriesList() {
        return userSeriesList;
    }

    public void setUserSeriesList(List<Serie> userSeriesList) {
        this.userSeriesList = userSeriesList;
    }
}
