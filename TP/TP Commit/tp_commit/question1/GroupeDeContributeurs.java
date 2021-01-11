package question1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class GroupeDeContributeurs extends Cotisant implements Iterable<Cotisant> {

    private List<Cotisant> liste;

    public GroupeDeContributeurs(String nomDuGroupe) {
        super(nomDuGroupe);
        this.liste = new ArrayList<>();

    }

    public void ajouter(Cotisant cotisant) {
        if (liste.contains(cotisant))
            System.out.println("Cotisant deja present");

        this.liste.add(cotisant);
        cotisant.setParent(this);

    }

    public int nombreDeCotisants() {
        int nombre = 0;

        for (Cotisant cotisant : liste) {
            nombre += cotisant.nombreDeCotisants();
        }
        return nombre;
    }

    public String toString() {
        // format attendu :  "<Contributeur : " + nom + "," + solde + ">"
        StringBuilder str = new StringBuilder();

        for (Cotisant cotisant : liste)
            str.append("<Contributeur :").append(cotisant.nom()).append(",").append(cotisant.solde()).append(">");

        return str.toString();
    }

    public List<Cotisant> getChildren() {
        return this.liste;
    }

    public void debit(int somme) throws SoldeDebiteurException {
        for (Cotisant cotisant : liste)
            cotisant.debit(somme);
    }

    public void credit(int somme) {
        for (Cotisant cotisant : liste)
            cotisant.credit(somme);
    }

    public int solde() {
        int solde = 0;

        for (Cotisant cotisant : liste)
            solde += cotisant.solde();

        return solde;
    }

    // methodes fournies

    public Iterator<Cotisant> iterator() {
        return new GroupeIterator(liste.iterator());
    }

    public <T> T accepter(Visiteur<T> visiteur) {
        return visiteur.visite(this);
    }

    private class GroupeIterator implements Iterator<Cotisant> {
        private Stack<Iterator<Cotisant>> stk;

        public GroupeIterator(Iterator<Cotisant> iterator) {
            this.stk = new Stack<Iterator<Cotisant>>();
            this.stk.push(iterator);
        }

        public boolean hasNext() {
            if (stk.empty()) {
                return false;
            } else {
                Iterator<Cotisant> iterator = stk.peek();
                if (!iterator.hasNext()) {
                    stk.pop();
                    return hasNext();
                } else {
                    return true;
                }
            }
        }

        public Cotisant next() {
            if (hasNext()) {
                Iterator<Cotisant> iterator = stk.peek();
                Cotisant cpt = iterator.next();
                if (cpt instanceof GroupeDeContributeurs) {
                    GroupeDeContributeurs gr = (GroupeDeContributeurs) cpt;
                    stk.push(gr.liste.iterator());
                }
                return cpt;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
