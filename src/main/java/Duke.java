import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        ArrayList<Task> myList;

        while (true) {
            FileReading reader = new FileReading();
            myList = reader.ReadFile();
            Scanner sc = new Scanner(System.in);
            String myInput = sc.nextLine();
            String[] sep_myInput = myInput.split(" ", 2);
            if (myInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (sep_myInput[0].equals("list")) {
                try {
                    if (myList.isEmpty()) throw new DukeException();
                    System.out.println("Here are the items in your list:");
                    int counter = 0;
                    for (Task task : myList) { //traverse all task in my list
                        counter++;
                        System.out.println(counter + "." + task.toString());
                    }
                } catch (DukeException e){
                    e.emptyList();
                }
            }
            else if (sep_myInput[0].equals("done")) {
                try {
                    if ((sep_myInput.length < 2)||(Integer.parseInt(sep_myInput[1]) > myList.size())) throw new DukeException();
                    //if(!(sep_myInput[1].trim().length() > 0)) throw new DukeException(); //safeguard statement might need to enable later
                    String prevData = myList.get(Integer.parseInt(sep_myInput[1])- 1).toText();
                    myList.get(Integer.parseInt(sep_myInput[1])-1).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + myList.get(Integer.parseInt(sep_myInput[1]) - 1).getStatusIcon() + "] " + myList.get(Integer.parseInt(sep_myInput[1]) - 1).description);
                    String currData = myList.get(Integer.parseInt(sep_myInput[1]) - 1).toText();
                    //Modify Duke.txt
                    FileWriting writer = new FileWriting();
                    writer.ModifyFile(prevData, currData);
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.DONE);
                }
            }
            else if (sep_myInput[0].equals("todo")) {
                try {
                    if (sep_myInput.length < 2) throw new DukeException();
                    //if(!(sep_myInput[1].trim().length() > 0)) throw new DukeException();//safeguard
                    ToDo newToDoTask = new ToDo(sep_myInput[1]);
                    myList.add(newToDoTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newToDoTask.toString());
                    //System.out.println("[T][âœ˜] " + sep_myInput[1]);
                    System.out.println("Now you have " + myList.size() + " task(s) in the list.");
                    //write to duke.txt
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newToDoTask.toText(), true);
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.TODO);
                }
            }
            else if (sep_myInput[0].equals("deadline")) {
                try {
                    if (sep_myInput.length < 2) throw new DukeException();
                    //if(!(sep_myInput[1].trim().length() > 0))throw new DukeException(); //safeguard statement
                    if (!sep_myInput[1].contains("/by")) {
                        throw new DukeException();
                    }
                    //check dateFormat
                    String[] dateFormat = sep_myInput[1].split("/by ");
                    if (dateFormat.length < 2) throw new DukeException();
                    //if((dateFormat[1].equals(" ")) || (dateFormat[0].equals("")))throw new DukeException();
                    Deadline newDeadlineTask = new Deadline(dateFormat[0], dateFormat[1]);
                    myList.add(newDeadlineTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newDeadlineTask.toString());
                    //System.out.println("[D][âœ˜] " + dateFormat[0] + "(by: " + dateFormat[1] + ")");
                    System.out.println("Now you have " + myList.size() + " tasks in the list.");
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newDeadlineTask.toText(), true);
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.DEADLINE);
                }
            }
            else if (sep_myInput[0].equals("event")) {
                try {
                    if ((sep_myInput.length < 2) || !(sep_myInput[1].trim().length() > 0)) throw new DukeException();
                    if (!sep_myInput[1].contains("/at")) throw new DukeException();
                    String[] dateFormat = sep_myInput[1].split("/at ");
                    if (dateFormat.length < 2) throw new DukeException();
                    //if((dateFormat[1].equals(" ")) || (dateFormat[0].equals("")))throw new DukeException();//safeguard
                    Event newEventTask = new Event(dateFormat[0], dateFormat[1]);
                    myList.add(newEventTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newEventTask.toString());
                    //System.out.println("[E][âœ˜] " + dateFormat[0] + "(at: " + dateFormat[1] + ")");
                    System.out.println("Now you have " + myList.size() + " tasks in the list.");
                    //Write to duke.txt
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newEventTask.toText(), true);
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.EVENT);
                }
            }
            else {
                try {
                    throw new DukeException();
                } catch (DukeException e){
                    e.invalidInstruction();
                }
            }
        }

    }
}


