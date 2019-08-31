import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.net.URI;

public class FileReading extends ManageFile {
    public ArrayList<Task> ReadFile(){ //return an ArrayList of Task based on ReadFile
        File file = new File("C:/Users/Jian Wei/Desktop/duke/data/duke.txt".toURI().getPath());
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            ArrayList<Task> list = new ArrayList<>();
            String currentLine = br.readLine(); //buffer will read line by line

            while(currentLine!=null) { //we have data, we carry on
                String[] words = currentLine.split("\\|"); //format is letterSymbol,status,description,and time/data(if applicable)
                if (words[0].equals("D")) { //belongs to deadline
                    Deadline item = new Deadline(words[2], words[3], words[1].contains("1")); //format: String description, String date, boolean status)
                    list.add(item);
                } else if (words[0].equals("E")) { //belongs to Event
                    Event item = new Event(words[2], words[3], words[1].contains("1")); //format: String description, String date, boolean status)
                    list.add(item);
                } else if (words[0].equals("T")) { //belongs to todo
                    ToDo item = new ToDo(words[2], words[1].contains("1")); //format: String description,boolean status)
                    list.add(item);
                }
            }
                //once no more item to read
                return list;
            }
            catch(IOException e){
            e.printStackTrace(); //locate where the exception is caught
            return null;
        }
    }
}
