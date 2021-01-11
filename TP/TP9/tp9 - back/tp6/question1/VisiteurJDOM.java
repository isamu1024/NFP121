package tp6.question1;

import java.io.*;

import org.jdom.Element;

public class VisiteurJDOM extends VisiteurParDefaut<Element> {

	private Contexte c;

	public VisiteurJDOM(Contexte c) {
		this.c = c;
	}

	public Element visite(Constante c) {
		Element cst = new Element("Constante");
		cst.setText(Integer.toString(c.valeur()));
		return cst;
	}

	public Element visite(Variable v) {
		Element varName = new Element("Variable");
		varName.setText(v.nom());
		return varName;
	}

	public Element visite(Division d) {
		Element division = new Element("Division");
		division.addContent(d.op1.accepter(this));
		division.addContent(d.op2.accepter(this));
		return  division;
	}

	public Element visite(Addition a) {
		Element addition = new Element("Addition");
		addition.addContent(a.op1.accepter(this));
		addition.addContent(a.op2.accepter(this));
		return addition;
	}

	public Element visite(Multiplication m) {
		Element multiplication = new Element("Multiplication");
		multiplication.addContent(m.op1.accepter(this));
		multiplication.addContent(m.op2.accepter(this));
		return multiplication;
	}

	public Element visite(Soustraction s) {
		Element soustraction = new Element("Soustraction");
		soustraction.addContent(s.op1.accepter(this));
		soustraction.addContent(s.op2.accepter(this));
		return  soustraction;
	}

	public Contexte contexte() {
		return c;
	}
	
}
