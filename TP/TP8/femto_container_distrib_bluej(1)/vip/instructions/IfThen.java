package vip.instructions;

public class IfThen<M> extends Instruction<M>{
  private static final boolean T = true; //false;//true;
  protected Condition<M>    condition;
  protected Instruction<M>  instruction;

  public void setCondition(Condition<M> condition){
      this.condition = condition;
  }
  public void setInstruction(Instruction<M> instruction){
      this.instruction = instruction;
  }
  public M execute(M memory){
      assert condition!=null && instruction!=null;
      if(T)System.out.println("condition.isSatisfied(memory): " + condition.isSatisfied(memory));
      if (condition.isSatisfied(memory)){
         M m1 = instruction.execute(memory);
         if(T)System.out.println("memoire après: " + m1);
         return m1;
      }else
         return memory;
    }
    

}
