package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_Mult1 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_Mult1 extends AST_Progr implements java.io.Serializable {
    /*
     * modèle "java Style" dont l'AST "WhileL style" est à construire ci dessous
     * a = n1 ; b = n2 ; produit = 0 ; while (b > 0) { produit = produit + a ;
     * b=b-1; } afficher(produit);
     */
    private final Contexte m = new Memoire();
    private final Variable produit = new Variable(m, "produit");
    private final Variable a = new Variable(m, "a");
    private final Variable b = new Variable(m, "b");
    private final Constante z = new Constante(0);
    private Instruction ast = null; // à compléter

    public AST_Mult1(int n1, int n2) {
        this.m.ecrire("a", n1);
        this.m.ecrire("b", n2);
        this.generateAst();
    }

    private void generateAst() {
        this.ast = new Sequence(
                new TantQue(new Sup(b, z),
                        new Sequence(new Affectation(produit, new Addition(produit, a)),
                                new Affectation(b, new Soustraction(b, new Constante(1))))),
                new Afficher(produit));
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }
}
