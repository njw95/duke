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
                mylist.forEach(System.out::println);
            }
            else {
                mylist.add(myCommand);
                System.out.println("added: "+myCommand);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
