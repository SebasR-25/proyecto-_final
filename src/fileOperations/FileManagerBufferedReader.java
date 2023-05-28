package fileOperations;

import java.io.*;

public class FileManagerBufferedReader {
    private BufferedReader bufferedReader = null;
    private File file=null;

    public FileManagerBufferedReader(String path, String fileName) throws IOException {
        file = new File(path+fileName);
        bufferedReader = new BufferedReader(new FileReader(file));
    }

    public String read() throws IOException {
        String texto = bufferedReader.readLine();
        return texto;
    }
   public void close() throws IOException {
        bufferedReader.close();
   }


}
