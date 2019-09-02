public class Event extends Task {
    public Event(String description, String date) {
        super(description);
        this.letterSymbol = "E";
        this.date = date;
    }
    public Event(String description, String date, boolean checkDone) {
        super(description);
        this.letterSymbol = "E";
        this.date = date;
        this.isDone = checkDone;
    }
    @Override
    public String toString() {
        return "[" + getLetterSymbol() + "]" + "[" + super.getStatusIcon() + "] " + super.getDescription() + "(at: " + getDate() + ")";
    }

    @Override
    public String toText() {
        return super.getLetterSymbol() + " | " + super.getStatus() + " | " + super.getDescription() + "| " + getDate();
    }
}