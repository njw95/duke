public class DukeException extends Exception {
    DukeException() {} //constructor

    public void emptyList(){
        System.out.println("☹ OOPS!!! The task list is empty. Please input some tasks before using this command.");
    }

    public void invalidInstruction(){
        System.out.println("☹ OOPS!!! There is no support for such instruction.");
    }

    enum typesOfError{ //enumerate all types of error we can have
        TODO,
        DEADLINE,
        EVENT,
        DONE
    }

    public void incorrectInputFormat(typesOfError error){
        switch(error){
            case TODO: System.out.println("Missing/Incorrect format detected. Please use \"todo [insert task description]\"");break;
            case DEADLINE: System.out.println("Missing/Incorrect format detected. Please use \"deadline [insert task description] /by [date/time]\"");break;
            case EVENT: System.out.println("Missing/Incorrect format detected. Please use \"event [insert task description] /at [date/time]\"");break;
            case DONE: System.out.println("Missing/Incorrect format detected. Please use \"done [insert index of task]\"");break;
        }
    }
}
