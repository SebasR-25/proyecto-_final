package pojo;

import com.google.gson.Gson;
import model.Serie;

import javax.xml.crypto.Data;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mian {
    public static void main(String[] args) throws IOException {
        System.out.println("Cargando");
        Response res;
        try {
            res = persistence();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(res.getLastUpdate());
        System.out.println();
        List<Serie> newJson = new ArrayList<>();
        Set<String> status = new HashSet<>();
        for (DataItem item : res.getData()) {
            if (newJson.size()<=500){
                Serie serie = new Serie();
                serie.setId(newJson.size());
                serie.setName(item.getTitle());
                serie.setGenres(item.getTags());
                status.add(item.getStatus());
                serie.setChapters(item.getEpisodes());
                newJson.add(serie);
            }
        }
        System.out.println(status);
        save(newJson);
    }

    private static void save(List<Serie> newJson) throws IOException {
        Gson gson = new Gson();
        FileWriter reader = new FileWriter("src/pojo/Adapt.json");
        reader.write(gson.toJson(newJson));
        reader.close();
    }

    public static Response persistence() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/pojo/anime-offline-database.json");
        Response response = gson.fromJson(reader, Response.class);
        reader.close();
        return response;
    }
}
