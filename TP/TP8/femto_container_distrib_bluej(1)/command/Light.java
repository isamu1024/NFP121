package command;

public class Light{
    private String status;
    public void turnOn(){
      this.status = "lampe allum�e";
      System.out.println(status);
    }
    
   public void turnOff(){
       this.status = "lampe �teinte";
       System.out.println(status);
    }
    
    public String getStatus(){
        return status;
    }
}
