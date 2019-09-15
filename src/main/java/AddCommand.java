public class AddCommand extends Command {
    AddCommand(Task givenTask){ //constructor
        task = givenTask;
    }
    @Override
    public void execute(TaskList tasks,Ui ui, Storage storage) {
        tasks.addTask(task); //taken from above
        storage.writeToFile(task.toTextFile(),true);
        ui.printAdded(task,tasks);//task is above, tasks is the arraylist of tasks
    }
}
