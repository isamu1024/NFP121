package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Calcul du factoriel d'un nombre entier depuis le langage WhileL
 *
 * @author Alexandre Moro
 * @version V1 20/12/2020
 */
public class AST_Fact extends AST_Progr implements java.io.Serializable {

    private final Contexte m = new Memoire();
    private final Variable xxx = new Variable(m, "xxx");
    private final Variable fact = new Variable(m, "fact");
    private final Variable n = new Variable(m, "n");
    private Instruction ast;

    /*
     * construire l'AST du programme "WhileL style" est à construire ci dessous
     * xxx:=n ; fact := 1 ; while (~(xxx=0) ) do fact := fact * xxx ; xxx:=
     * xxx-1; ftp; afficher(fact); remarque : on calcule ici fact(n) i.e. n est
     * une donnée fournie au moment de l'exécution, d'où le constructeur suivant
     */
    public AST_Fact(int n) {
        this.m.ecrire("n", n);
        this.generateAst();
    }

    /**
     * Méthode générant l'arbre de syntaxe abstraite après affectation de la valeur à calculer dans
     * la mémoire.
     */
    private void generateAst() {

        this.ast = new Sequence(
                new Affectation(this.xxx, this.n),
                new Sequence(
                        new Affectation(this.fact, new Constante(1)),
                        new Sequence(
                                new TantQue(new Non(new Egal(this.xxx, new Constante(0))),
                                        new Sequence(
                                                new Affectation(this.fact, new Multiplication(this.fact, this.xxx)),
                                                new Affectation(this.xxx, new Soustraction(this.xxx, new Constante(1))))
                                ),
                                new Afficher(this.fact))
                )
        );
    }

    public Contexte getMem() {
        return this.m;
    }

    public Instruction getAST() {
        return this.ast;
    }

}
