import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("Hello I'm Duke\nWhat Can I do for you?");

        ArrayList<Task> myList = new ArrayList<Task>();

        while (true) {
            Scanner sc = new Scanner(System.in);
            String myInstruction = sc.nextLine();

            if (myInstruction.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (myInstruction.equals("list")) { //list out everything
                if (myList.isEmpty()) System.out.println("List is empty."); //list empty
                else { //list has items
                    int counter = 0;
                    System.out.println("This is your current list.");
                    for (Task task : myList) { //for all task in myList, traverse and print
                        // [0] is the taskName, [1] is the symbol
                        counter++;
                        System.out.println(counter + ".[" + task.getStatusIcon() + "] " + task.description);
                    }
                }
            }
            else if (myInstruction.contains("done")) { //mark task number as done
                String words[] = myInstruction.split("\\s"); //splits the string based on whitespace
                myList.get(Integer.parseInt(words[1]) - 1).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + myList.get(Integer.parseInt(words[1]) - 1).getStatusIcon() + "] " + myList.get(Integer.parseInt(words[1]) - 1).description);
            }
            else { //adding tasks with undone marker/cross symbol
                Task newTask = new Task(myInstruction);
                myList.add(newTask);
                System.out.println("added: " + myInstruction);
            }
        }
    }
}
