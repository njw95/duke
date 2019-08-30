import java.util.Scanner;
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
        while(true){
            Scanner sc = new Scanner(System.in);
            myCommand = sc.nextLine();
            if(myCommand.equals("bye"))break;
            else System.out.println(myCommand);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
