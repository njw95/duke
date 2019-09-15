public abstract class Command {
    public Task task;
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        //does nothing in here
    }
    public boolean isExit() {
        return false;
    };
}
