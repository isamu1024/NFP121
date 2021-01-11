package question3;

import java.io.*;

import question1.*;
import question2.*;

/**
 * 
 */
public class VisiteurInstToJava extends VisiteurInstruction<String> {

    private final static int TAB = 2;
    private static final String lineSeparator = System.getProperties().getProperty("line.separator");

    private VisiteurExpression<String> vi;
    private VisiteurExpressionBooleenne<String> vb;

    private int tabulations;

    /**
     * Cr�ation d'un visiteur d'instructions
     * 
     * @param vi
     *            le visiteur d'expressions arithm�tiques
     * @param vb
     *            le visiteur d'expression bool�ennes
     * @param tabulations
     *            tabulations initiales
     */
    public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb, int tabulations) {
        this.vi = vi;
        this.vb = vb;
        this.tabulations = tabulations;
    }

    /**
     * Cr�ation d'un visiteur d'instructions
     * 
     * @param vi
     *            le visiteur d'expressions arithm�tiques
     * @param vb
     *            le visiteur d'expression bool�ennes
     */
    public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb) {
        this(vi, vb, 0);
    }

    /**
     * obtention du contexte, ici celui du visiteur d'expression arithm�tiques
     * 
     * @return le contexte ici de vi(le visiteur d'expression)
     */
    public Contexte contexte() {
        return this.vi.contexte();
    }

    /**
     * Visite d'une instance de la classe Affectation.
     * 
     * 
     * @param a
     *            une affectation
     * @return a := exp
     */
    public String visite(Affectation a) {
        return a.v().accepter(this.vi) + "=" + a.exp().accepter(this.vi);
    }

    /**
     * Visiste d'une s�quence seq(I1,I2) <br>
     * 
     * @param seq
     *            une s�quence
     * @return i1;i2
     */
    public String visite(Sequence seq) {
        String seqString = tab(2)  + seq.i1().accepter(this);
        if (seq.i1() instanceof Affectation)
            seqString += ";";

        seqString += tab(2) + seq.i2().accepter(this);
        if (seq.i2() instanceof Affectation)
            seqString += ";";
        tab(-2);

        return seqString; // � compl�ter
    }

    public String visite(Selection sel) {
        String selString = "if" + sel.cond().accepter(vb) + "{";
        selString += sel.i1().accepter(this);
        
        if (sel.i1() instanceof Affectation)
            selString += ";";
            
        selString += tab(2) +"}";

        if (sel.i2() != null) {
            selString += "else" + tab(2) + "{";
            selString += sel.i2().accepter(this);
            selString += tab(-2)+ "};";
        }
        
        tabulations -= 2;

        return selString; // � compl�ter
    }

    public String visite(TantQue tq) {

        String tqString = "while" + tq.cond().accepter(vb);
        tqString += tab(2) + "{";

        tqString += tq.i1().accepter(this);

        if (tq.i1() instanceof Affectation)
            tqString += ";";
            
        tqString += tab(2) + "};";

        return tqString; // � compl�ter
    }

    public String visite(Pour pour) {
        String pString =  "for(";
        pString += pour.init().accepter(this)+ ";";
        pString += pour.cond().accepter(vb) + ";";
        pString += pour.inc().accepter(this);
        pString += ")";

        pString += tab(2) + "{";

        if (!(pour.i1() instanceof Iteration || pour.i1() instanceof Sequence || pour.i1() instanceof Afficher))
            pString += tab(2);

        pString += pour.i1().accepter(this);
        if (pour.i1() instanceof Affectation)
            pString += ";";
        pString += tab(-2) + "};";
        
        tab(-2);

        return pString;
    }

    public String visite(Afficher a) {
        return "System.out.println(" + a.exp().accepter(vi) + ");"; // � compl�ter
    }

    public String visite(Assertion a) {
        return "assert(" + a.cond().accepter(this.vb) + ");"; // � compl�ter
    }

    private String tab(int n) {
        String str = new String();

        str = str + lineSeparator;
        for (int i = 0; i < this.tabulations + n; i++) {
            str = str + " ";
        }
        this.tabulations += n;
        return str;
    }

}
