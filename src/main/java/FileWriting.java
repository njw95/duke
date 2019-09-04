import java.io.*;
import java.util.ArrayList;

public class FileWriting extends FilePathManager {
    public void WriteFile(String data, boolean append) {
        File file = new File(FILE_PATH);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, append);
            bw = new BufferedWriter(fw);
            bw.write(data);//writes a string
            bw.newLine(); //writes a line separator
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {//close after using
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ModifyFile(String prevData, String currData) {
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String oldCopy = "";
            String bufferLine = br.readLine();

            while ( bufferLine!= null) {
                oldCopy = oldCopy + bufferLine + System.lineSeparator();
                bufferLine = br.readLine();
            }
            oldCopy = oldCopy.substring(0, oldCopy.length() - 1);
            String newContent = oldCopy.replace(prevData, currData);
            FileWriting writer = new FileWriting();
            writer.WriteFile(newContent, false);
        }
        catch (IOException e) {
            e.printStackTrace();
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

            while ( bufferLine!= null) {
                oldCopy = oldCopy + bufferLine + System.lineSeparator();
                bufferLine = br.readLine();
            }
            oldCopy = oldCopy.substring(0, oldCopy.length() - 1);
            String newContent = oldCopy.replace(toBeDeleted,"null");//replace the string to be deleted with nothing
            FileWriting writer = new FileWriting();
            writer.WriteFile(newContent, false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
