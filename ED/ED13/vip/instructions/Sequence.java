package vip.instructions;

public class Sequence<M> extends Instruction<M>{
  private static final boolean T = false; //false;//true;
  protected Instruction<M>  instruction1;
  protected Instruction<M>  instruction2;

  public void setInstruction1(Instruction<M> instruction1){
      this.instruction1 = instruction1;
  }
  public void setInstruction2(Instruction<M> instruction2){
      this.instruction2 = instruction2;
  }
  
  public M execute(M memory){
    M memory1 = instruction1.execute(memory);
    if(T)System.out.println("Sequence:memoire1: " + memory1);
    M memory2 = instruction2.execute(memory1);
    if(T)System.out.println("Sequence:memoire2: " + memory2);
    return memory2;
    }
    
}


