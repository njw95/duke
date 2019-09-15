public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        try{
            if(tasks.getList().isEmpty()){
                throw new DukeException(DukeException.typesOfError.EMPTY_LIST);
            }
            ui.printList(tasks);
        }
        catch(DukeException e){
            e.printError();
        }
    }
}
