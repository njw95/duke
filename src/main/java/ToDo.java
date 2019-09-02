public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
        this.letterSymbol = "T";
    }
    public ToDo(String description, boolean checkDone) {
        super(description);
        this.isDone = checkDone;
        this.letterSymbol = "T";
    }
}