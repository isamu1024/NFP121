package command;



public class Projecteur{
    private String status = "projecteur �teint";
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void turnOn(){
      this.status = "projecteur allum�";
      System.out.println(status);
    }
    
   public void turnOff(){
       this.status = "projecteur �teint";
       System.out.println(status);
    }
    
    public String getStatus(){
        return status;
    }
}
