package vip.examples.instructions;


public class VisitorString extends vip.instructions.VisitorString{
    
    public String visit(Inc inc){
        return "inc("+ inc.operand + ")";
    }
    
    public  String visit(IncVariable inc){
        return "incVariable()";
    }
    
    public  String visit(LessThan lessThan){
        return "<=" + lessThan.operand;
    }
 
}
