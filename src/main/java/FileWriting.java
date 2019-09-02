import java.io.*;

public class FileWriting extends FilePathManager {
    public void WriteFile(String data, boolean append) {
        File file = new File(FILE_PATH);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, append);
            bw = new BufferedWriter(fw);
            bw.write(data);//writes a string
            bw.newLine(); //writes a line separataor
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
            String prev_item = "";
            String bufferLine = br.readLine();

            while ( bufferLine!= null) {
                prev_item = prev_item + bufferLine + System.lineSeparator();
                bufferLine = br.readLine();
            }
            prev_item = prev_item.substring(0, prev_item.length() - 1);
            String newContent = prev_item.replace(prevData, currData);
            FileWriting writer = new FileWriting();
            writer.WriteFile(newContent, false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}