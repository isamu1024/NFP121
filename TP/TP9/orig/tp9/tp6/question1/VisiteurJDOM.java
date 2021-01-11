package tp6.question1;

import java.io.*;

import org.jdom.Element;

public abstract class VisiteurJDOM extends VisiteurParDefaut<Element> {

	private Contexte c;

	public VisiteurJDOM(Contexte c) {
		this.c = c;
	}

	// à compléter

	public Contexte contexte() {
		return c;
	}
	
}
