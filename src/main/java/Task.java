public class Task {
    protected String description;
    protected String letterSymbol;
    protected String date;
    protected boolean isDone;

    public Task(String description, String letterSymbol) {
        this.description = description;
        this.isDone = false;
        this.letterSymbol = letterSymbol; //T,D, and E
    }

    public Task(String description, String letterSymbol, String date) {
        this.description = description;
        this.isDone = false;
        this.letterSymbol = letterSymbol; //T,D, and E
        this.date = date;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        this.isDone = true;
    }
}