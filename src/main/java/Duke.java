import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("Hello I'm Duke\nWhat Can I do for you?");

        ArrayList<Task>myList = new ArrayList<>();

        while (true) {
            FileReading reader = new FileReading();
            myList = reader.ReadFile();
            Scanner sc = new Scanner(System.in);
            String myInstruction = sc.nextLine();
            String[] words = myInstruction.split("\\s",2); //split into command todo,deadline,event,done then desc

            if (words[0].equals("bye")) { //bye
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (words[0].equals("list")) {
                try {
                    if (myList.isEmpty()) throw new DukeException();
                    //list has items
                    int counter = 0;
                    System.out.println("Here are the tasks in your list:");
                    for (Task task : myList) { //for all task in myList, traverse and print
                        counter++;
                        System.out.println(counter + "." + task.toString());
                    }
                }
                    catch(DukeException e){
                        e.emptyList(); //prints out emptyList message from DukeException
                }
            }
            else if (myInstruction.contains("done")) { //done
                try {
                    if ((words.length < 2) || (words[1].equals("")) || (Integer.parseInt(words[1]) - 1 > myList.size()))
                        throw new DukeException();
                    //if no error, proceed
                    String prevData = myList.get(Integer.parseInt(words[1]) - 1).toTextData();
                    myList.get(Integer.parseInt(words[1]) - 1).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + myList.get(Integer.parseInt(words[1]) - 1).getStatusIcon() + "] " + myList.get(Integer.parseInt(words[1]) - 1).description);
                    String currData = myList.get(Integer.parseInt(words[1]) - 1).toTextData();
                    //Modify Duke.txt here, need to update the isDone
                    FileWriting writer = new FileWriting();
                    writer.ModifyFile(prevData,currData);
                }
                catch(DukeException e){ //catch the error if it was thrown above
                        e.incorrectInputFormat(DukeException.typesOfError.DONE);
                }
            }
            else if(myInstruction.contains("todo")){
                try {
                    if ((words.length < 2) || (words[1].equals("")))
                        throw new DukeException();
                    //if no error, proceed
                    ToDo newToDoTask = new ToDo(words[1]); //pass taskName as description
                    myList.add(newToDoTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newToDoTask.toString());
                    System.out.println("Now you have " + myList.size() + " tasks in the list.");
                    //update Duke.txt here
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newToDoTask.toTextData(),true); //write using data text format
                }
                catch(DukeException e){
                    e.incorrectInputFormat(DukeException.typesOfError.TODO);
                }
            }
            else if(myInstruction.contains("deadline")) {
                try {
                    if ((words.length < 2) || !(words[1].contains("/by")))//must contain /by
                        throw new DukeException();
                    //ensure date format is correct
                    String[] dateFormat = words[1].split("/by"); // "taskDescription" and "dd/mm/yy" separated
                    if (dateFormat[1].equals("")) throw new DukeException();

                    Deadline newDeadlineTask = new Deadline(dateFormat[0], dateFormat[1]);
                    myList.add(newDeadlineTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newDeadlineTask.toString());
                    System.out.println("Now you have " + myList.size() + " tasks in the list.");
                    //update Duke.txt here
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newDeadlineTask.toTextData(),true); //write using data text format

                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.DEADLINE);
                }
            }
            else if(myInstruction.contains("event")) {
                try {
                    if ((words.length < 2) || !(words[1].contains("/at")))//must contain /at
                        throw new DukeException();
                    //ensure date format is correct
                    String[] dateFormat = words[1].split("/at"); // "taskDescription" and "dd/mm/yy" separated
                    if (dateFormat[1].equals("")) throw new DukeException();

                    Event newEventTask = new Event(dateFormat[0], dateFormat[1]);
                    myList.add(newEventTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newEventTask.toString());
                    System.out.println("Now you have " + myList.size() + " tasks in the list.");
                    //update Duke.txt here
                    FileWriting writer = new FileWriting();
                    writer.WriteFile(newEventTask.toTextData(),true);//write using data text format
                } catch (DukeException e) {
                    e.incorrectInputFormat(DukeException.typesOfError.EVENT);
                }
            }
            else { //all other unsupported instructions
                try{
                    DukeException e = new DukeException();
                    throw e;
                }
                catch (DukeException e){
                    e.invalidInstruction();
                }
            }
        }
    }
}
