public class DukeException extends Exception {
    protected typesOfError error;
    protected String eType;

    enum typesOfError { //enumerate all types of error
        TODO,
        DEADLINE,
        EVENT,
        DONE,
        DELETE,
        FIND,
        EMPTY_LIST,
        INVALID_COMMAND,
        INDEX_ISSUE;
    }
    DukeException(typesOfError e) {
        error = e;
    }
    public void printError() {
        switch(error) {
            case TODO: System.out.println("Missing/Incorrect format detected. Please use \"todo [insert task description]\"");break;
            case DEADLINE: System.out.println("Missing/Incorrect format detected. Please use \"deadline [insert task description] /by [DD/MM/YYYY] [HHMM]\"");break;
            case EVENT: System.out.println("Missing/Incorrect format detected. Please use \"event [insert task description] /at [DD/MM/YYYY] [HHMM]\"");break;
            case DONE: System.out.println("Missing/Incorrect format detected. Please use \"done [insert index of task]\"");break;
            case DELETE: System.out.println("Missing/Incorrect format detected. Please use \"delete [insert index of task] to delete the item. Ensure that index is correct.\"");break;
            case FIND: System.out.println("Missing/Incorrect format detected. Please use \"find [insert keyword] to allow lookup. Please ensure you have a keyword inserted\"");break;
            case EMPTY_LIST: System.out.println("☹OOPS!!! The task list is empty. Please input some item into list before using this command.");break;
            case INVALID_COMMAND: System.out.println("☹OOPS!!! There is no support for such instruction.");break;
            case INDEX_ISSUE: System.out.println("The index you have given is out of range, please enter valid index.");break;
        }
        System.out.println("Remember to ommit the [ ] brackets when you type your task description, date and time.");
    }
}