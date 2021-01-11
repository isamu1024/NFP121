package tp6.question2;

import java.io.*;
import org.jdom.Element;

import tp6.question1.VisiteurExpression;

public class VisiteurBoolJDOM extends VisiteurExpressionBooleenne<Element> {

	private VisiteurExpression<Element> ve;

	public VisiteurBoolJDOM(VisiteurExpression<Element> ve) {
		this.ve = ve;
	}

	public Element visite(Vrai v){
		Element vrai = new Element("Vrai");
		vrai.addContent(v.accepter(this));
		return vrai;
	}

	public Element visite(Faux f){
		Element faux  = new Element("Faux");
		faux.addContent(f.accepter(this));
		return faux;
	}

	public Element visite(Non n){
		Element non = new Element("Non");
		non.addContent(n.bop().accepter(this));
		return non;
	}

	public Element visite(Ou o){
		Element ou = new Element("Ou");
		ou.addContent(o.bop1().accepter(this));
		ou.addContent(o.bop2().accepter(this));
		return ou;
	}

	public Element visite(Et e){
		Element et = new Element("Et");
		et.addContent(e.bop1().accepter(this));
		et.addContent(e.bop2().accepter(this));
		return et;
	}

	public Element visite(Sup s){
		Element sup = new Element("Sup");
		sup.addContent(s.op1().accepter(this.ve));
		sup.addContent(s.op2().accepter(this.ve));
		return sup;
	}

	public Element visite(Egal e){
		Element egal = new Element("Egal");
		egal.addContent(e.op1().accepter(this.ve));
		egal.addContent(e.op2().accepter(this.ve));
		return egal;
	}

	public Element visite(Inf i){
		Element inf = new Element("Inf");
		inf.addContent(i.op1().accepter(this.ve));
		inf.addContent(i.op2().accepter(this.ve));
		return inf;
	}

}
