package vip.rules;


public class Printer<E,R> implements ICommand<E, R>{
  private String prefix = "";
  public void setPrefix(String prefix){
      this.prefix = prefix;
  }
  @Override
  public R execute(E e, R r){
      System.out.println(prefix + e.toString() + " " + r.toString());
      return r;
  }
  public String toString(){return "printer();";}
}
