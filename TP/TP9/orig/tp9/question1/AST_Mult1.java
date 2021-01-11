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
	private Contexte m = new Memoire();

	public AST_Mult1(int n1, int n2) {
		m.ecrire("a", n1);
		m.ecrire("b", n2);
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
