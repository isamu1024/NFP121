package tp6.question3;

import org.jdom.Element;

import tp6.question1.Contexte;
import tp6.question1.VisiteurExpression;
import tp6.question2.VisiteurExpressionBooleenne;

/**
 * Visiteur d'instruction, chaque classe concrète possède une implémentation de
 * la visite
 * 
 */
public abstract class VisiteurInstJDOM extends VisiteurInstruction<Element> {

	private VisiteurExpression<Element> vi;
	private VisiteurExpressionBooleenne<Element> vb;

	/**
	 * Création d'un visiteur d'instructions
	 * 
	 * @param vi
	 *            le visiteur d'expressions arithmétiques
	 * @param vb
	 *            le visiteur d'expression booléennes
	 */
	public VisiteurInstJDOM(VisiteurExpression<Element> vi,
			VisiteurExpressionBooleenne<Element> vb) {
		this.vi = vi;
		this.vb = vb;
	}

	/**
	 * obtention du contexte,
	 * 
	 * @return le contexte ici de vi(le visiteur d'expression)
	 */
	public Contexte contexte() {
		return this.vi.contexte();
	}

	// à compléter

}
