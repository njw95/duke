import java.io.*;

public class FileWriting extends ManageFile {
    public void WriteFile(String data, boolean append){ //follows FileWriter Constructor format
        File file = new File(FILE_PATH);
        FileWriter fwr = null;
        BufferedWriter bwr = null;
        try{
            fwr = new FileWriter(file,append);
            bwr = new BufferedWriter(fwr);
            bwr.write(data);//writes string
            bwr.newLine(); //writes a line separator
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{ //close after using
            try{
                bwr.close();
                fwr.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void ModifyFile(String prevData, String currData){
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br= null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String prev_item="";
            String now = br.readLine();

            while(now!=null){//make sure we have item in our file before we modify
                prev_item+=now+System.lineSeparator();
                now = br.readLine();
            }
            prev_item=prev_item.substring(0,prev_item.length()-1);
            String updatedItem = prev_item.replace(prevData,currData);
            //write the new updated item into the file
            FileWriting writer = new FileWriting();
            writer.WriteFile(updatedItem,false);//do not append
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
