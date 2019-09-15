public class Task {
    protected String description;
    protected String date;
    protected String type;
    protected boolean isDone;

    public Task(String description) { //constructor
        this.description = description;
        this.isDone = false;
    }
    public String getStatusIcon() { return (isDone ? "✔" : "✘"); }
    //public String getStatusIcon() { return (isDone ? "\u2713" : "\u2718"); } //issue with javaFX
    public int getStatus() { return (isDone ? 1 : 0); }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getDate() { return date; }
    public void markAsDone() {
        this.isDone = true;
    }
    public String toString() {
        return "[" + getType() + "]" + "[" + getStatusIcon() + "] " + getDescription();
    }
    public String toTextFile() {
        return getType() + " | " + getStatus() + " | " + getDescription();
    }
}
