package question3;

public class Adaptateur implements Prise{
  public Plug adaptee;
  public Adaptateur(Plug adaptee){
    this.adaptee = adaptee;
  }
  public void peritel(){
    adaptee.RCA();
  }
}