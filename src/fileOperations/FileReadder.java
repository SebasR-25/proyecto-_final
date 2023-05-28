package fileOperations;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.*;

public class FileReadder{
	private List<Serie> series;

	public void loadFileJson() throws FileNotFoundException, IOException {
		FileManagerBufferedReader fr = new FileManagerBufferedReader("src/resources/" , "series.json");
		Type postListType = new TypeToken<ArrayList<Serie>>() {
		}.getType();
		String json = fr.read();
		series = new Gson().fromJson(json, postListType);
	}

	public List<Serie> getSeries() {
		return series;
	}
}

