package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_SOM_W ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_SOM_W extends AST_Progr implements java.io.Serializable {
    /*
     * modèle "java Style" dont l'AST "WhileL style" est à construire ci dessous
     * n=100; som = 0 ; while (n> 0) { som = som+n ; n = n - 1 ; }
     * afficher(som);
     */

    private final Contexte m = new Memoire();
    private Instruction ast = null;
    private final Variable som = new Variable(m, "som");
    private final Variable n = new Variable(m, "n");


    public AST_SOM_W(int n) {
        this.m.ecrire("n", n);
        this.generateAst();
    }

    private void generateAst() {
        this.ast = new Sequence(
                new TantQue(
                new Sup(n, new Constante(0)),
                new Sequence(
                        new Affectation(som, new Addition(som, n)),
                        new Affectation(n, new Soustraction(n, new Constante(1)))
                )),
                new Afficher(som));
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }
}
