import java.util.Arrays;

public class Parser {

    public static Command parse(String myInput) {
        String[] sep_myInput = myInput.split(" ", 2);
        try {
            /**These keywords will call their respective function to do processing*/
            if (myInput.equals("bye")) {
                return new ExitCommand();
            } else if (myInput.equals("list")) {
                return new ListCommand();
            } else if (sep_myInput[0].equals("done")) {
                if (sep_myInput.length < 2) throw new DukeException(DukeException.typesOfError.DONE);
                return new DoneCommand(Integer.parseInt(sep_myInput[1]));
            } else if (sep_myInput[0].equals("todo")) {
                if (sep_myInput.length < 2) throw new DukeException(DukeException.typesOfError.TODO);
                ToDo newToDoTask = new ToDo(sep_myInput[1]);
                return new AddCommand(newToDoTask);
            } else if (sep_myInput[0].equals("deadline")) {
                if (sep_myInput.length < 2) throw new DukeException(DukeException.typesOfError.DEADLINE);
                //if(!(sep_myInput[1].trim().length() > 0))throw new DukeException(); //safeguard statement
                if (!sep_myInput[1].contains("/by")) {
                    throw new DukeException(DukeException.typesOfError.DEADLINE);
                }
                //check dateFormat
                String[] dateFormat = sep_myInput[1].split("/by "); //description and date+time
                if (dateFormat.length < 2) throw new DukeException(DukeException.typesOfError.DEADLINE);
                Datentime dnt = new Datentime();
                dateFormat[1] = dnt.extractDnT(dateFormat[1]);
                if (dateFormat[1].equals("null")) throw new DukeException(DukeException.typesOfError.INVALID_COMMAND);
                Deadline newDeadlineTask = new Deadline(dateFormat[0], dateFormat[1]);
                return new AddCommand(newDeadlineTask);
            } else if (sep_myInput[0].equals("event")) {
                if ((sep_myInput.length < 2)) throw new DukeException(DukeException.typesOfError.EVENT);
                //if!(sep_myInput[1].trim().length() > 0)) throw new DukeException();
                if (!sep_myInput[1].contains("/at")) throw new DukeException(DukeException.typesOfError.EVENT);
                String[] dateFormat = sep_myInput[1].split("/at ");
                if (dateFormat.length < 2) throw new DukeException(DukeException.typesOfError.EVENT);
                Datentime dnt = new Datentime();
                dateFormat[1] = dnt.extractDnT(dateFormat[1]);
                if (dateFormat[1].equals("null")) throw new DukeException(DukeException.typesOfError.EVENT);
                Event newEventTask = new Event(dateFormat[0], dateFormat[1]);
                return new AddCommand(newEventTask);
            } else if (sep_myInput[0].equals("delete")) {
                if (sep_myInput.length < 2) {
                    throw new DukeException(DukeException.typesOfError.DELETE);
                }
                return new DeleteCommand(Integer.parseInt(sep_myInput[1]));
            } else if (sep_myInput[0].equals("find")) {
                if (sep_myInput.length < 2)
                    throw new DukeException(DukeException.typesOfError.FIND);
                //create a FindCommand
                return new FindCommand(sep_myInput[1]);
            } else {
                try {
                    throw new DukeException(DukeException.typesOfError.INVALID_COMMAND);
                } catch (DukeException e) {
                    e.printError();
                    return new InvalidCommand();
                }
            }
        }
            catch(DukeException e) {
            e.printError();
            return new InvalidCommand();
        }//end catch
    }//close parse
}//close class

