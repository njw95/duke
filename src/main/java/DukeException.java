public class DukeException extends Exception {
    DukeException() {} //constructor

    //if list command but list is empty
    public void emptyList() {
        System.out.println("☹ OOPS!!! The task list is empty. Please myInput some myList before using this command.");
    }

    //if command is invalid
    public void invalidInstruction() {
        System.out.println("☹ OOPS!!! There is no support for such instruction.");
    }

    enum typesOfError { //enumerate all types of error
        TODO,
        DEADLINE,
        EVENT,
        DONE
    }
    public void incorrectInputFormat(typesOfError error) {
        switch(error) {
            case TODO: System.out.println("Missing/Incorrect format detected. Please use \"todo [insert task description]\"");break;
            case DEADLINE: System.out.println("Missing/Incorrect format detected. Please use \"deadline [insert task description] /by [date/time]\"");break;
            case EVENT: System.out.println("Missing/Incorrect format detected. Please use \"event [insert task description] /at [date/time]\"");break;
            case DONE: System.out.println("Missing/Incorrect format detected. Please use \"done [insert index of task]\"");break;
        }
    }
}

