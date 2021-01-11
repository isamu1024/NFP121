package vip.examples.instructions;

import java.util.*;

public class Memory{
  private Map<String,Element> map;
  
  public Memory(){
      this.map = new HashMap<>();
  }
  
  public <E> void set(String name, Element<E> e){
      map.put(name,e);
  }
  public <E>  Element<E> get(String name){
      return map.get(name);
  }
  public String toString(){
      return map.toString();
  }
}
