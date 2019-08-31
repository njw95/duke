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

            if (myInstruction.equals("bye")) { //bye
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (myInstruction.equals("list")) { //list now supports Symbol T,E,D on top of the tick/cross
                if (myList.isEmpty()) System.out.println("List is empty."); //list empty
                else { //list has items
                    int counter = 0;
                    System.out.println("Here are the tasks in your list:");
                    for (Task task : myList) { //for all task in myList, traverse and print
                        counter++;
                        System.out.println(counter+"."+task.toString());
                    }
                }
            }
            else if (myInstruction.contains("done")) { //done
                String[] words = myInstruction.split("\\s");
                myList.get(Integer.parseInt(words[1]) - 1).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + myList.get(Integer.parseInt(words[1]) - 1).getStatusIcon() + "] " + myList.get(Integer.parseInt(words[1]) - 1).description);
            }
            else if(myInstruction.contains("todo")){
                String[] words = myInstruction.split("\\s",2);
                ToDo newToDoTask = new ToDo(words[1]); //pass taskName as description
                myList.add(newToDoTask);
                System.out.println("Got it. I've added this task:");
                System.out.println(newToDoTask.toString());
                System.out.println("Now you have "+myList.size()+" tasks in the list.");
            }
            else if(myInstruction.contains("deadline")){
                String[] words = myInstruction.split("\\s",2); //"deadline" and "instruction /by day"
                String[] TaskDesc = words[1].split("/",2); //"instruction" and "by day/full date"
                String[] TaskDate = TaskDesc[1].split("\\s",2); //"by" and "day"
                Deadline newDeadlineTask = new Deadline(TaskDesc[0],TaskDate[1]);
                myList.add(newDeadlineTask);
                System.out.println("Got it. I've added this task:");
                System.out.println(newDeadlineTask.toString());
                System.out.println("Now you have "+myList.size()+" tasks in the list.");
            }
            else if(myInstruction.contains("event")){
                String[] words = myInstruction.split("\\s",2); //"event" and "instruction /by day"
                String[] TaskDesc = words[1].split("/",2); //"instruction" and "at day/full date"
                String[] TaskDate = TaskDesc[1].split("\\s",2); //"by" and "day"
                Event newEventTask = new Event(TaskDesc[0],TaskDate[1]);
                myList.add(newEventTask);
                System.out.println("Got it. I've added this task:");
                System.out.println(newEventTask.toString());
                System.out.println("Now you have "+myList.size()+" tasks in the list.");
            }
            else { //Normal adding no longer works without proper instruction
                System.out.println("Please use proper instruction "+ "\"todo\""+ ", " + "\"deadline\"" +"or"+ "\"event\"");
            }
        }
    }
}
