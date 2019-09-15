public class DeleteCommand extends Command {
    public int index;

    DeleteCommand(int givenIndex) {
        index = givenIndex - 1; //for array usage
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            if (index > tasks.getSize()) {
                throw new DukeException(DukeException.typesOfError.INDEX_ISSUE);
            }
            if (tasks.getList().isEmpty()) {
                throw new DukeException(DukeException.typesOfError.EMPTY_LIST);
            }
            ui.printDeleted(tasks.getTask(index));
            storage.removefromFile(tasks.getItemInfo(index) + "\n"); //delete the line too
            tasks.deleteTask(index);
        } catch (DukeException e) {
            e.printError();
        }
    }
}
