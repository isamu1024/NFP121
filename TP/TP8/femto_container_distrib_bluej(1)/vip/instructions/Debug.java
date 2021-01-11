package vip.instructions;

public class Debug<M> extends Instruction<M>{
 
  public M execute(M memory){
    System.out.println("Debug:memory: " + memory);
    return memory;
    }

}
