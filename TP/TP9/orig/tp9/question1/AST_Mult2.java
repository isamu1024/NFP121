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
	private Contexte m = new Memoire();

	public AST_Mult2(int n1, int n2) {
		m.ecrire("m1", n1);
		m.ecrire("m2", n2);
	}

	private Instruction ast = null; // à compléter

	// à compléter

	public Contexte getMem() {
		return m;
	}

	public Instruction getAST() {
		return ast;
	}

}
