package vip.examples.instructions;

public class Variable implements Element<Integer>{
    private static final boolean T = false; //true;
    
    private int value;

    @Override
    public void setValue(Integer elt){
        if(T) System.out.println("setValue: " + elt);
        this.value = elt;
    }

    public Integer getValue(){
        return value;
    }
    
    public String toString(){
        return Integer.toString(this.value);
    }
    
    public boolean equals(Object obj){
        if(!(obj instanceof Variable)) return false;
        Variable v = (Variable)obj;
        return this.value == v.value;
    }
    public int hashCode(){
        return this.value;
    }
}
