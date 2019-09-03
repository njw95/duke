import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;
import java.text.ParseException;

public class Duke {
    private static String filePath = "D:/DukeDatabase/ArrayList";
    public static void main(String[] args) {
        File Database = new File(filePath);
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
                    printGotIt(newToDoTask,myList.size());
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
                    Datentime dnt = new Datentime();
                    dateFormat[1]=dnt.extractDnT(dateFormat[1]);
                    if(dateFormat[1].equals("null")) throw new DukeException();
                    Deadline newDeadlineTask = new Deadline(dateFormat[0], dateFormat[1]);
                    myList.add(newDeadlineTask);
                    printGotIt(newDeadlineTask,myList.size());
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newDeadlineTask.toText(), true);
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.DEADLINE);
                }
            }
            else if (sep_myInput[0].equals("event")) {
                try {
                    if ((sep_myInput.length < 2))throw new DukeException();
                    //if!(sep_myInput[1].trim().length() > 0)) throw new DukeException();
                    if (!sep_myInput[1].contains("/at")) throw new DukeException();
                    String[] dateFormat = sep_myInput[1].split("/at ");
                    if (dateFormat.length < 2) throw new DukeException();
                    Datentime dnt = new Datentime();
                    dateFormat[1]=dnt.extractDnT(dateFormat[1]);
                    if(dateFormat[1].equals("null")) throw new DukeException();
                    Event newEventTask = new Event(dateFormat[0], dateFormat[1]);
                    myList.add(newEventTask);
                    printGotIt(newEventTask,myList.size());
                    //Write to duke.txt
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newEventTask.toText(), true);
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.EVENT);
                }
            }

            else if (sep_myInput[0].equals("delete")) {
                try {
                    if ((sep_myInput.length < 2)||Integer.parseInt(sep_myInput[1]) > myList.size())throw new DukeException();
                    //if!(sep_myInput[1].trim().length() > 0)) throw new DukeException(); //safeguard
                    String dataToDelete = myList.get(Integer.parseInt(sep_myInput[1]) - 1).toText();
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(myList.get(Integer.parseInt(sep_myInput[1]) - 1).toString());//print String
                    FileWriting writer = new FileWriting();
                    writer.removefromFile(dataToDelete); //remove from file
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.DELETE);
                }
            }
            }

    }
    public static void printGotIt(Task currentTask, int sizeOfList){
        System.out.println("Got it. I've added this task:");
        System.out.println(currentTask.toString());
        System.out.println("Now you have " + sizeOfList + " task(s) in the list.");
    }
}


