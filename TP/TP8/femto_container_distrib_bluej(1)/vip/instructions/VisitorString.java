package vip.instructions;


public class VisitorString extends Visitor<String>{
    private static final int TAB=2;
    
    private int tab;

    private String tab(int tab){
        this.tab = tab;
        String s = new String();
        for(int i=0;i<tab;i++){
            s = s +" ";
        }
        return s;
    }
    
    public <M> String visit(Sequence<M> sequence){
        return sequence.instruction1.accept(this) + ";" +
               sequence.instruction2.accept(this);
    }
    
    public <M> String visit(IfThen<M> ifThen){
        return "if(" + ifThen.condition.accept(this) + "){\n" +
               tab(tab+TAB) + ifThen.instruction.accept(this) + "\n"+
               tab(tab-TAB) + "}";
    }
    public <M> String visit(While<M> whil){
        return "while(" + whil.condition.accept(this) + "){\n" +
               tab(tab+TAB) + whil.instruction.accept(this) + "\n"+
               tab(tab-TAB) + "}\n";
    }
    public <M> String visit(Debug<M> debug){
        return "debug()";
    }
    
    public <M> String visit(Not<M> not){
        return "not(" + not.condition.accept(this) + ")";
    }
    public <M> String visit(And<M> and){
        return "and(" + and.condition1.accept(this) + "," +
                        and.condition2.accept(this) + ")";
    }
    public <M> String visit(Or<M> or){
        return "or(" + or.condition1.accept(this) + "," +
                       or.condition2.accept(this) + ")";
    }    
    
}
