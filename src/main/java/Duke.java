import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
        echo();
    }
    public static void echo() {
        String myCommand="";
        List<String> mylist = new ArrayList<>();
        while(true){
            Scanner sc = new Scanner(System.in);
            myCommand = sc.nextLine();
            if(myCommand.equals("bye"))break;
            else if(myCommand.equals("list")){
                printList(mylist);
            }
            else { //list
                mylist.add(myCommand);
                System.out.println("added: "+myCommand);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void printList(List<String> mylist){
        for(int i = 0; i < mylist.size(); i++) {
            System.out.println(i+1 + ". " + mylist.get(i));
        }
    }
}

