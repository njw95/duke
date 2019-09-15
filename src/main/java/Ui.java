import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public String readCommand(){
        Scanner input = new Scanner(System.in);
        String output = input.nextLine();
        return output;
    }

    public void showWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }
    public void sayBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }
    public void printDone(Task t) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(t.toString());
    }
    public void printDeleted(Task t) {
        System.out.println("As requested. I've removed this task:");
        System.out.println(t.toString());
    }
    public void printFound(ArrayList<Task> searchResult) {
        if (searchResult.size()> 0) {
            System.out.println("Here are the matching tasks in your list:");
            int index = 0;
            for (Task task : searchResult) { //for all task in result arrayList
                System.out.println((++index) + ". " + task.toString()); //print
            }
        } else {
            System.out.println("No task matching description. Try another keyword!");
        }
    }
    public void printAdded(Task currentTask, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(currentTask.toString());
        System.out.println("Now you have " + tasks.getSize() + " task(s) in the list.");
    }
    public void printList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        int index = 0;
        for (Task task : tasks.getList())
            System.out.println(++index + "." + task.toString());
    }
}
