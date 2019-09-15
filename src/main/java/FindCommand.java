import java.util.ArrayList;

public class FindCommand extends Command {
    public String keyword;
    FindCommand(String givenWord){
        keyword = givenWord;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        ArrayList<Task> searchResults = tasks.searchForTask(keyword);
        ui.printFound(searchResults);
    }
}
