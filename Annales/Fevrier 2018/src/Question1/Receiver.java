package Question1;



public class Receiver implements ReceiverI{
  private String messageReceived;
  private String name;
  
  public Receiver(String name){
    this.name = name;
  }
  public Receiver(){}
  
  public void setName(String name){
    this.name = name;
  }

  public String getName(){
      return name;
  }
    
  public void receive(String msg) throws Exception{
    this.messageReceived = msg;
  }
  
  public String toString(){
    return "Receiver: " + getName() + "last received: " + messageReceived;
  }
  
  public boolean equals(Object obj){
      if(!(obj instanceof Receiver))return false;
      Receiver r = (Receiver)obj;
      return r.getName().equals(getName());
  }
  public int hashCode(){
      return getName().hashCode();
    }

}
