public class Datentime {
    public String extractDnT (String data){ //we will pass everything from /by or /at onwards
        String[] dataSet = data.split(" "); //split into date and time
        String[] dateInfo = dataSet[0].split("/"); //get individual numbers of the date part dd/mm/yy
        if(Integer.parseInt(dateInfo[0])<10) dateInfo[0]=Integer.toString(Integer.parseInt(dateInfo[0]));

        if(dateInfo.length==3){//it must have 3 parts dd mm yyyy
            if(dataSet.length==1){ //Only the presence of date, no time
                return dateInfo[0] +getSuffix(dateInfo[0])+ " of " + getMonth(Integer.parseInt(dateInfo[1]))+" " + dateInfo[2];
            }
            else if(dataSet.length==2){ //has date and time
                return dateInfo[0] +getSuffix(dateInfo[0])+ " of " + getMonth(Integer.parseInt(dateInfo[1]))+" " + dateInfo[2]+ ", " + getTime(dataSet[1]);
            }
            else{ //3 or more parts, invalid
                return "null";
            }
        }
        return "null";
    }

    public String getSuffix(String myStringDay){
        int day = Integer.parseInt(myStringDay);
        String suffix = "";
        if(day==11||day==12||day==13){
            suffix = "th";
        }
        else{
            int lastDigit = day%10;
            switch(lastDigit) {
                case 1: suffix="st";break;
                case 2: suffix="nd";break;
                case 3: suffix="rd";break;
                default : suffix = "th";
            }
        }
        return suffix;
    }

    public String getMonth(int number){
        String allMonths[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return allMonths[number-1];
    }

    public String getTime(String dataTime){

       String hours = dataTime.substring(0,2);
       String minutes = dataTime.substring(2);
       String time_Suffix="";
       int int_Hours=Integer.parseInt(hours);
       int int_Minutes=Integer.parseInt(minutes);
       if(int_Minutes==0) minutes = "00";

       if(int_Hours<12) time_Suffix="am";
       else if(int_Hours>=12 && int_Hours<24){
           time_Suffix = "pm";
           if (int_Hours != 12) {
               int_Hours = int_Hours % 12;
           }
       }
       return Integer.toString(int_Hours)+"."+ minutes +time_Suffix;
    }

}
