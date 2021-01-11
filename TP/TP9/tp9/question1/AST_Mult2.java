package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_Mult2 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_Mult2 extends AST_Progr implements java.io.Serializable {
    /*
     * a := 7 ; b := 85 ; produit := 0 ; m1:=a ; m2:=b; while (m2 > 0) do if
     * (m2/2*2)=m2 then m1:= m1*2 ; m2 := m2/2;end produit := produit + m1 ;
     * m2:=m2-1; end afficher(produit);
     */
    private final Contexte m = new Memoire();
    private final Variable produit = new Variable(m, "produit");
    private final Variable m1 = new Variable(m, "m1");
    private final Variable m2 = new Variable(m, "m2");
    private Instruction ast = null; // à compléter

    public AST_Mult2(int n1, int n2) {
        m.ecrire("m1", n1);
        m.ecrire("m2", n2);
        this.generateAst();
    }

    private void generateAst() {
        this.ast = new Sequence(new TantQue(
                new Sup(
                        m2, new Constante(0)),
                new Sequence(
                        new Selection(
                                new Egal(
                                        new Multiplication(
                                                new Division(m2, new Constante(2)), new Constante(2)), m2),
                                new Sequence(new Affectation(m1, new Multiplication(m1, new Constante(2))),
                                        new Affectation(m2, new Division(m2, new Constante(2))))),
                        new Sequence(
                                new Affectation(produit, new Addition(produit, m1)),
                                new Affectation(m2, new Soustraction(m2, new Constante(1))))
                )
        ), new Afficher(produit));
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }

}
