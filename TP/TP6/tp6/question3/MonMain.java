package question3;

import question1.*;
import question2.*;

/**
 * Décrivez votre classe MonMain ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MonMain
{
    public void Factoriel(){
        Contexte m = new Memoire();
        Variable x = new Variable(m,"x",5);
        Variable fact = new Variable(m,"fact",1);
        VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(m);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);

        Instruction i = 
            new TantQue(
                new Sup(x,new Constante(1)),
                new Sequence(
                    new Affectation(fact,new Multiplication(fact,x)),
                    new Affectation(x,new Soustraction(x,new Constante(1))))
            );

        System.out.println(i.accepter(vi));     
    }

    public void Mult(){

        Contexte m = new Memoire();
        Variable a = new Variable(m,"a",7);
        Variable b = new Variable(m,"b",85);
        Variable z = new Variable(m,"z",0);

        VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(m);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);

        Instruction i = 
            new TantQue(
                new Sup(b,new Constante(0)),
                new Selection(
                    new Egal(
                        new Soustraction(b,new Multiplication(new Division(b,new Constante(2)),new Constante(2))),new Constante(1)),
                    new Sequence(
                        new Affectation(z,new Addition(z,a)),
                        new Affectation(b,new Soustraction(b,new Constante(1))) 
                    ),
                    new Sequence(
                        new Affectation(a,new Multiplication(a,new Constante(2))),
                        new Affectation(b,new Division(b,new Constante(2)))
                    )
                )
            );

        System.out.println(i.accepter(vi));

    }

    public void UneBouclePour() throws Exception{

        Contexte m = new Memoire();
        Variable i = new Variable(m,"i");
        Variable j = new Variable(m,"j",1);

        new TantQue( 
            new Inf(i,new Constante(10)),
            new Sequence(
                new TantQue(
                    new Inf(j,new Constante(10)),
                    new Pour( 
                        new Affectation(i,new Constante(0)), new Inf(i, new Constante(5)), 
                        new Sequence(
                            new Affectation(i,new Addition(i,new Constante(1))),
                            new Afficher(i)), 
                        new Affectation(j,new Addition(j,new Constante(1)))
                    )),
                new Sequence(
                    new Affectation(i,new Addition(i,new Constante(1))),
                    new Affectation(j, new Constante(1))
                )
            )
        );

    }
}
