public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
        this.type = "T";
    }
    public ToDo(String description, boolean checkDone) {
        super(description);
        this.isDone = checkDone;
        this.type = "T";
    }
}
