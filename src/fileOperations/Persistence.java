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

    public Persistence() {
        userList = new ArrayList<>();
        try {
            loadUserList();
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

    public void saveData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter(PropertiesManager.getInstance().getProperty("USERS_FILE_PATH"));
            fileWriter.write(gson.toJson(userList));
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
}
