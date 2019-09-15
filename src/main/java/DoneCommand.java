public class DoneCommand extends Command {
    public int index;

    DoneCommand(int givenIndex){
        index = givenIndex-1; //for use in array
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        try{
            if(index>tasks.getSize()){
                throw new DukeException(DukeException.typesOfError.INDEX_ISSUE);
            }
            if(tasks.getList().isEmpty()){
                throw new DukeException(DukeException.typesOfError.EMPTY_LIST);
            }
            tasks.markItemDone(index);
            storage.writeToFile(tasks.convertArrayToString(),false);
            ui.printDone(tasks.getTask(index));
        }
        catch(DukeException e){
            e.printError();
        }
    }
}
