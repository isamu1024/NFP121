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

	public AST_SOM_F(int n) {
		m.ecrire("n", n);
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
