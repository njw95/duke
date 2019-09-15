public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.readFile()); //read file from the FILEPATH into a TaskList and pass it to tasks
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                if(fullCommand == "") {
                    throw new DukeException(DukeException.typesOfError.INVALID_COMMAND);
                }
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                e.printError();
            }
        }
    }
    public static void main(String[] args) {
        new Duke("C:\\Users\\Jian Wei\\Desktop\\duke\\data\\duke.txt").run();
    }
}

