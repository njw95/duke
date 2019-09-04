public class DukeException extends Exception {
    DukeException() {} //constructor

    //if list command but list is empty
    public void emptyList() {
        System.out.println("☹OOPS!!! The task list is empty. Please input some item into list before using this command.");
    }

    //if command is invalid
    public void invalidInstruction() {
        System.out.println("☹OOPS!!! There is no support for such instruction.");
    }

    enum typesOfError { //enumerate all types of error
        TODO,
        DEADLINE,
        EVENT,
        DONE,
        DELETE,
        FIND;
    }
    public void incorrectInputFormat(typesOfError error) {
        switch(error) {
            case TODO: System.out.println("Missing/Incorrect format detected. Please use \"todo [insert task description]\"");break;
            case DEADLINE: System.out.println("Missing/Incorrect format detected. Please use \"deadline [insert task description] /by [DD/MM/YYYY] [HHMM]\"");break;
            case EVENT: System.out.println("Missing/Incorrect format detected. Please use \"event [insert task description] /at [DD/MM/YYYY] [HHMM]\"");break;
            case DONE: System.out.println("Missing/Incorrect format detected. Please use \"done [insert index of task]\"");break;
            case DELETE: System.out.println("Missing/Incorrect format detected. Please use \"delete [insert index of task] to delete the item. Ensure that index is correct.\"");break;
            case FIND: System.out.println("Missing/Incorrect format detected. Please use \"find [insert keyword] to allow lookup. Please ensure you have a keyword inserted\"");break;
        }
        System.out.println("Remember to ommit the [ ] brackets when you type your task description, date and time.");
    }
}