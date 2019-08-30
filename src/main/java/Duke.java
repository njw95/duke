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

        String myInstruction = "";
        ArrayList<String[]> myList = new ArrayList<String[]>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            myInstruction = sc.nextLine();
            if (myInstruction.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (myInstruction.equals("list")) { //list out everything
                if (myList.isEmpty()) System.out.println("List is empty."); //list empty
                else { //list has items
                    int counter = 0;
                    System.out.println("This is your current list.");
                    for (String[] task : myList) { //[1] is the symbol, [0] is the item
                        counter++;
                        System.out.println(counter + ".[" + task[1] + "] " + task[0]);
                    }
                }
            } else if (myInstruction.contains("done")) { //mark task number as done
                String keyword[] = myInstruction.split(" "); //split the words into different strings
                myList.get(Integer.parseInt(keyword[1]) - 1)[1] = "✓"; //find the [i]-1 element in the list and get symbol
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + myList.get(Integer.parseInt(keyword[1]) - 1)[1] + "] " + myList.get(Integer.parseInt(keyword[1]) - 1)[0]);
            } else {
                String[] newTask = {myInstruction, "✗"};
                myList.add(newTask);
                System.out.println("added: " + myInstruction);
            }
        }
    }
}
