package vip.instructions;

public class While<M> extends Instruction<M>{
  private static final boolean T = false; // true;
  
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
      if(condition.isSatisfied(memory)){
          // M m1 = instruction.execute(memory);
          // while (condition.isSatisfied(m1)){
              // m1 = instruction.execute(m1);
              // if(T)System.out.println("m1: " + m1);
          // }
          // return m1;
          // si la condition est vraie, le corps de la boucle est exécuté
          M m1 = instruction.execute(memory); 
          
          While<M> whil = new While();
          whil.setCondition(condition);
          whil.setInstruction(instruction);
          return whil.execute(m1);
      }else
        return memory;

    }
    

}
