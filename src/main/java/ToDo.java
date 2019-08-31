public class ToDo extends Task {
     public ToDo(String description){ //dont need by cause no date
         super(description);
     }
     @Override
    public String toString(){
         return "[T]" +"["+super.getStatusIcon()+"] "+super.toString();
     }
}
