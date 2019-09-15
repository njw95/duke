public class Deadline extends Task {
    public Deadline(String description, String date) {
        super(description);
        this.type = "D";
        this.date = date;
    }
    public Deadline(String description, String date, boolean checkDone) {
        super(description);
        this.type = "D";
        this.date = date;
        this.isDone = checkDone; //checkDone will report true/false for isDone which gets converted to INT
    }
    @Override
    public String toString() {
        return "[" + getType() + "]" + "[" + super.getStatusIcon() + "] " + super.getDescription() + "(by: " + super.getDate() + ")";
    }
    @Override
    public String toTextFile() {
        return super.getType() + " | " + super.getStatus() + " | " + super.getDescription() + "| " + super.getDate();
    }
}