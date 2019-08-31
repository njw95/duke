public class ToDo extends Task {
     public ToDo(String description){
         super(description);
         this.letterSymbol="T";
     }
     public ToDo(String description, boolean status){
         super(description);
         this.letterSymbol="T";
         this.isDone = status;
     }

}
