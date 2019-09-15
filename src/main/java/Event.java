public class Event extends Task {
    public Event(String description, String date) {
        super(description);
        this.type = "E";
        this.date = date;
    }
    public Event(String description, String date, boolean checkDone) {
        super(description);
        this.type = "E";
        this.date = date;
        this.isDone = checkDone;
    }
    @Override
    public String toString() {
        return "[" + getType() + "]" + "[" + super.getStatusIcon() + "] " + super.getDescription() + "(at: " + getDate() + ")";
    }

    /**Text File requires a different format from String printing*/
    @Override
    public String toTextFile() {
        return super.getType() + " | " + super.getStatus() + " | " + super.getDescription() + "| " + getDate();
    }
}