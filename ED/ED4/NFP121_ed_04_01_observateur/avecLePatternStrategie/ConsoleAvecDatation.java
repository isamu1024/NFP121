package avecLePatternStrategie;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;

public class ConsoleAvecDatation extends Strategie{
 

  public void action(Observable source, Object arg){
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    System.out.println(dateFormat.format(date) + " source: " + source + " ," + arg);
  }
}
