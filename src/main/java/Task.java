public class Task {
    protected String description;
    protected String date;
    protected boolean isDone;

    public Task(String description) { //handling of letterSymbol and dates to be done in respective classes.
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public String toString(){
        return this.description;
    }
}