package vip.instructions;


public abstract class Instruction<M>{
  public M execute(M memory){return memory;}
  
  public <T> T accept(Visitor<T> visitor){
      return visitor.visit(this);
    }
}
