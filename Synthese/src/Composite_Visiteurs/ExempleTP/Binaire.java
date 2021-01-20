package Composite_Visiteurs.ExempleTP;

public class Binaire extends Expression {
    private Expression op1, op2;

    public Binaire(Expression op1, Expression op2){
        this.op1 = op1;
        this.op2 = op2;
    }

    public Expression getOp1(){
        return this.op1;
    }
    public Expression getOp2(){
        return this.op2;
    }
}
