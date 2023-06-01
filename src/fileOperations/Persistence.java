package fileOperations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Serie;
import model.User;
import resources.PropertiesManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistence {
    private List<User> userList;
    private List<Serie> seriesList;
    private List<String> genereList;

    public Persistence() {
        userList = new ArrayList<>();
        genereList = new ArrayList<>();
        seriesList = new ArrayList<>();
        try {
            loadGenereList();
            loadUserList();
            loadSeriesList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading files");
        }
    }

    private void loadUserList() throws IOException {
        File file = new File(PropertiesManager.getInstance().getProperty("USERS_FILE_PATH"));
        file.getParentFile().mkdirs();
        FileReader fileReader = new FileReader(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User[] users = gson.fromJson(fileReader, User[].class);
        userList.addAll(List.of(users));
        fileReader.close();
    }

    private void loadGenereList() throws IOException {
        FileReader fileReader = new FileReader(PropertiesManager.getInstance().getProperty("GENERES_FILE_PATH"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String[] generes = gson.fromJson(fileReader, String[].class);
        genereList.addAll(List.of(generes));
        fileReader.close();
    }

    private void loadSeriesList() throws IOException {
        File file = new File(PropertiesManager.getInstance().getProperty("SERIES_FILE_PATH"));
        file.getParentFile().mkdirs();
        FileReader fileReader = new FileReader(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Serie[] series = gson.fromJson(fileReader, Serie[].class);
        seriesList.addAll(List.of(series));
        fileReader.close();
    }

    public void SaveData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter(PropertiesManager.getInstance().getProperty("USERS_FILE_PATH"));
            fileWriter.write(gson.toJson(userList));
            fileWriter.write(gson.toJson(userList));
            fileWriter.write(gson.toJson(seriesList));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving files");
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Serie> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Serie> seriesList) {
        this.seriesList = seriesList;
    }

    public List<String> getGenereList() {
        return genereList;
    }

    public void setGenereList(List<String> genereList) {
        this.genereList = genereList;
    }
}
