import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading extends FilePathManager {

    public ArrayList<Task> ReadFile() {
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            ArrayList<Task> myList = new ArrayList<>();
            String bufferLine = br.readLine();

            while (bufferLine != null) {
                String[] words = bufferLine.split("\\| ");
                if (words[0].equals("D ")) { //careful of the space, must include
                    Deadline item = new Deadline(words[2], words[3], words[1].contains("1"));
                    myList.add(item);
                } else if (words[0].equals("E ")) {
                    Event item = new Event(words[2], words[3], words[1].contains("1"));
                    myList.add(item);
                }
                else if (words[0].equals("T ")) {
                    ToDo item = new ToDo(words[2], words[1].contains("1"));
                    myList.add(item);
                }
                bufferLine = br.readLine();
            }
            return myList;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
