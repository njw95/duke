import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Storage {

    private static String FILE_PATH = "C:\\Users\\Jian Wei\\Desktop\\duke\\data\\duke.txt";

    Storage() {
    }

    Storage(String filePath) {
        FILE_PATH = filePath;
    }

    public ArrayList<Task> readFile() { //return type is ArrayList of tasks
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            ArrayList<Task> listOfTasks = new ArrayList<>();
            String bufferLine = br.readLine();

            while (bufferLine != null) {
                String[] words = bufferLine.split("\\| ");
                if (words[0].equals("D ")) { //careful of the space, must include
                    Deadline item = new Deadline(words[2], words[3], words[1].contains("1"));
                    listOfTasks.add(item);
                } else if (words[0].equals("E ")) {
                    Event item = new Event(words[2], words[3], words[1].contains("1"));
                    listOfTasks.add(item);
                } else if (words[0].equals("T ")) {
                    ToDo item = new ToDo(words[2], words[1].contains("1"));
                    listOfTasks.add(item);
                }
                bufferLine = br.readLine();
            }
            return listOfTasks;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally { //close pointers
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//end read

    public void writeToFile(String data, boolean append) {
        File file = new File(FILE_PATH);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, append);
            bw = new BufferedWriter(fw);
            bw.write(data);//writes a string
            bw.newLine(); //writes a line separator
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//close after using
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removefromFile(String toBeDeleted) { //pass the string that we want to delete in form of Text
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String oldCopy = "";
            String bufferLine = br.readLine();

            while (bufferLine != null) {
                oldCopy = oldCopy + bufferLine + System.lineSeparator();
                bufferLine = br.readLine();
            }
            oldCopy = oldCopy.substring(0, oldCopy.length() - 1);
            String newContent = oldCopy.replace(toBeDeleted, "");//replace the string to be deleted with nothing
            Storage writer = new Storage();
            writer.writeToFile(newContent, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//close pointers
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
