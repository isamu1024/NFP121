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
	public AST_SOM_W(int n) {
		m.ecrire("n", n);
	}

	private Contexte m = new Memoire();
	private Instruction ast = null; // à compléter

	// à compléter

	public Contexte getMem() {
		return m;
	}

	public Instruction getAST() {
		return ast;
	}

}
