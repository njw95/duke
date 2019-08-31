public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String date) {
        super(description);
        this.letterSymbol = "D";
        this.date = date;
    }

    public Deadline(String description, String date, boolean status){
        super(description);
        this.letterSymbol = "D";
        this.date = date;
        this.isDone=status;//the status will reflect true/false for isDone
    }

    @Override
    public String toString() {
        return "["+getLetterSymbol()+"]" + "["+super.getStatusIcon()+"] "+ super.getDescription() + "(by: " + super.getDate() + ")";
    }

    @Override
    public String toTextData() {
        return super.getLetterSymbol()+"|"+super.getStatus()+"|"+super.getDescription()+"|"+super.getDate();
    }
}