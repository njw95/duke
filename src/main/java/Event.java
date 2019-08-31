public class Event extends Task {

    public Event(String description, String date) {
        super(description);
        this.letterSymbol="E";
        this.date=date;
    }
    public Event(String description, String date,boolean status) {
        super(description);
        this.letterSymbol="E";
        this.date=date;
        this.isDone = status;
    }

    @Override
    public String toString() {
        return "[" +super.getLetterSymbol()+"]" +"["+super.getStatusIcon()+"] "+ super.getDescription() + "(at: " + super.getDate() + ")";
    }

    @Override
    public String toTextData() {
        return super.getLetterSymbol()+"|"+super.getStatus()+"|"+super.getDescription()+"|"+super.getDate();
    }
}