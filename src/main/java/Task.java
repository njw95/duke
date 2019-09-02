public class Task {
    protected String description;
    protected String date;
    protected String letterSymbol;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public String getStatusIcon() { return (isDone ? "\u2713" : "\u2718"); }
    public int getStatus() { return (isDone ? 1 : 0); }
    public String getDescription() { return description; }
    public String getLetterSymbol() { return letterSymbol; }
    public String getDate() { return date; }
    public void markAsDone() {
        this.isDone = true;
    }
    public String toString() {
        return "[" + getLetterSymbol() + "]" + "[" + getStatusIcon() + "] " + getDescription();
    }
    public String toText() {
        return getLetterSymbol() + " | " + getStatus() + " | " + getDescription();
    }
}
