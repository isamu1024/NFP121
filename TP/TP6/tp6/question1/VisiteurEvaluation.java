package question1;

public class VisiteurEvaluation extends VisiteurParDefaut<Integer> {

    private Contexte c;

    public VisiteurEvaluation(Contexte c) {
        this.c = c;
    }

    public Integer visite(Constante c){
        return c.valeur();
    }

    public Integer visite(Variable v){
        return c.lire(v.nom());
    }

    public Integer visite(Division d){
        int dividende = d.op1.accepter(this);
        int diviseur = d.op2.accepter(this);

        if (diviseur == 0)
            throw new ArithmeticException();
        else {
            return dividende / diviseur;
        }
    }

    public Integer visite(Addition a) {
        return a.op1().accepter(this) + a.op2().accepter(this);
    }

    public Integer visite(Multiplication m) {
        return m.op1().accepter(this) * m.op2().accepter(this);
    }

    public Integer visite(Soustraction s) {
        return s.op1().accepter(this) - s.op2().accepter(this);
    }

    public Contexte contexte() {
        return c;
    }

}
