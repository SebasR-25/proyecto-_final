package fileOperations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import model.Serie;

public class FileWritter {
    public FileWriter fw;
    File file;

    public void write(String value) throws IOException {
        file = new File("src/resources/series.json");
        fw = new FileWriter(file);
        fw.write(value);
        close();
    }
    public void close() throws IOException {
        fw.close();
    }
    public String getJson(Serie serie){
        Gson gson = new Gson();
        String jsonString = gson.toJson(serie);
        return jsonString;
    }
}
