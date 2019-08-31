public class Task {
    protected String description;
    protected String date;
    protected String letterSymbol;
    protected boolean isDone;

    public Task(String description) { //handling of letterSymbol and dates to be done in respective classes.
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public int getStatus(){ return isDone?1:0; }
    public String getDescription(){ return description;}
    public String getLetterSymbol(){ return letterSymbol; }
    public String getDate(){ return date;}
    public void markAsDone(){ this.isDone = true; }

    public String toString(){ //format for printing string
        return "["+ getLetterSymbol()+"]"+"["+getStatusIcon()+"]"+getDescription();
    }
    public String toTextData(){ //format for text file
        return getLetterSymbol()+"|"+getStatus()+"|"+getDescription();
    }
}