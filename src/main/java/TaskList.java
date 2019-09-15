import java.util.ArrayList;
import java.util.Arrays;

public class TaskList {

    protected ArrayList<Task> myTasks;

    TaskList(ArrayList<Task> list) { //constructor myTasks based on the given list
        myTasks = list;
    }
    public void addTask(Task t) {
        myTasks.add(t);
    }
    public void deleteTask(int index) {
        myTasks.remove(index);
    }
    public ArrayList<Task> getList() { //method for retrieving myTasks
        return myTasks;
    }
    /**Returns the specific task*/
    public Task getTask(int index) { //obtain task based on Index
        return myTasks.get(index);
    }
    /**Returns a task in format ready for txt file*/
    public String getItemInfo(int index) {
        return myTasks.get(index).toTextFile();
    }
    /**converts the ArrayList to String for storage into txt file*/
    public String convertArrayToString() {
        String inputStr = "";
        for (Task task : myTasks) {
            inputStr = inputStr + task.toTextFile() + System.lineSeparator();
        }
        inputStr = inputStr.substring(0, inputStr.length() - 1);
        return inputStr;
    }
    /**Marks an item done by passing the index*/
    public void markItemDone(int index) {
        myTasks.get(index).markAsDone();
    }
    /**Returns a ArrayList of items found that matches the key*/
    public ArrayList<Task> searchForTask(String key) {
        ArrayList<Task> searchResults = new ArrayList<>();
        for (Task t : myTasks) {
            String[] words = t.getDescription().split(" ");
            if (Arrays.asList(words).contains(key)) {
                searchResults.add(t);
            }
        }
        return searchResults;
    }
    public int getSize(){
        return myTasks.size();
    }
}
