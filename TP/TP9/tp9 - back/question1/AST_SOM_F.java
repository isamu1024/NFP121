package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_SOM_F ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_SOM_F extends AST_Progr implements java.io.Serializable {
    /*
     * n=100; som = 0 ; for(i=0 ; i<n ; i++){ (n> 0) { som := som+i ; }
     * afficher(som);
     */
    private Contexte m = new Memoire();
    private Variable som = new Variable(m, "som");
    private Variable i = new Variable(m, "i");
    private Variable n = new Variable(m, "n");
    private Instruction ast = null;

    public AST_SOM_F(int n) {
        this.m.ecrire("n", n);
        this.generateAst();
    }

    //    som := 0;
    //for (i = 0; i < n; i++) { (n> 0) {
    //        som := som + i;
    //    }

    private void generateAst() {
        this.ast = new Sequence(new Sequence(
                new Affectation(new Variable(m, "som"), new Constante(0)),
                new Sequence(
                        new Affectation(new Variable(m, "i"), new Constante(0)),
                        new TantQue(new Inf(i, n), new Sequence(
                                new Affectation(som, new Addition(som, i)),
                                new Affectation(i, new Addition(i, new Constante(1))))
                        )
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
