package tp6.question3;

import org.jdom.Element;

import org.junit.Assert;
import tp6.question1.Contexte;
import tp6.question1.VisiteurExpression;
import tp6.question2.VisiteurExpressionBooleenne;

/**
 * Visiteur d'instruction, chaque classe concrète possède une implémentation de
 * la visite
 * 
 */
public class VisiteurInstJDOM extends VisiteurInstruction<Element> {

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

	public Element visite(Affectation a){
		Element affectation = new Element("Affectation");
		affectation.addContent(a.v().accepter(this.vi));
		affectation.addContent(a.exp().accepter(this.vi));
		return affectation;
	}

	public Element visite(Sequence s){
		Element sequence = new Element("Sequence");
		sequence.addContent(s.i1().accepter(this));
		sequence.addContent(s.i2().accepter(this));
		return sequence;
	}

	public Element visite(Selection s){
		Element selection = new Element("Selection");
		selection.addContent(s.cond().accepter(this.vb));
		selection.addContent(s.i1().accepter(this));
		return selection;
	}

	public Element visite(TantQue t){
		Element tantque = new Element("TantQue");
		tantque.addContent(t.cond().accepter(this.vb));
		tantque.addContent(t.i1().accepter(this));
		return tantque;
	}

	public Element visite(Pour p){
		Element pour = new Element("Pour");
		pour.addContent(p.init().accepter(this));
		pour.addContent(p.cond().accepter(this.vb));
		pour.addContent(p.inc().accepter(this));
		return pour;
	}

	public Element visite(Afficher a){
		Element afficher = new Element("Afficher");
		afficher.addContent(a.exp().accepter(this.vi));
		return afficher;
	}

	public Element visite(Assertion a){
		Element assertion = new Element("Assertion");
		assertion.addContent(a.cond().accepter(this.vb));
		return assertion;
	}

}
