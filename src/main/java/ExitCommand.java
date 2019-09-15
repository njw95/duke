public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        ui.sayBye();
        isExit(); //this command can only flag true in this class
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
