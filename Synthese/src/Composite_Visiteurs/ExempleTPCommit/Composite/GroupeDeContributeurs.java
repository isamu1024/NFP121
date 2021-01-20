package Composite_Visiteurs.ExempleTPCommit.Composite;

import java.util.*;

public class GroupeDeContributeurs extends Cotisant implements Iterable<Cotisant> {

    private final List<Cotisant> liste;

    public GroupeDeContributeurs(String nomDuGroupe) {
        super(nomDuGroupe);
        this.liste = new ArrayList<>();
    }

    public void ajouter(Cotisant cotisant) {
        if (this.liste.contains(cotisant))
            System.out.println("Cotisant déjà présent");

        this.liste.add(cotisant);
        cotisant.setParent(this);
    }

    public int nombreDeCotisants() {
        int nombre = 0;

        for (Cotisant cotisant : this.liste)
            nombre += cotisant.nombreDeCotisants(); // rappel la feuille renvoi 1
        return nombre;
    }

    /**
     * @return format attendu :  "<Contributeur : " + nom + "," + solde + ">"
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Cotisant cotisant : this.liste)
            str.append("<Contributeur : ").append(cotisant.getNom()).append(",").append(cotisant.getSolde()).append(">");
        return str.toString();
    }

    public List<Cotisant> getChildren() {
        return this.liste;
    }

    public void debit(int somme) throws SoldeDebiteurException {
        for (Cotisant cotisant : this.liste)
            cotisant.debit(somme);
    }

    public void credit(int somme) {
        for (Cotisant cotisant : liste)
            cotisant.credit(somme);
    }

    public int getSolde() {
        int solde = 0;

        for (Cotisant cotisant : this.liste)
            solde += cotisant.getSolde();
        return solde;
    }

    public Iterator<Cotisant> iterator() {
        return new GroupeIterator(liste.iterator());
    }

    public <T> T accepter(Visiteur<T> visiteur) {
        return visiteur.visite(this);
    }

    private class GroupeIterator implements Iterator<Cotisant> {
        private final Stack<Iterator<Cotisant>> stk;

        public GroupeIterator(Iterator<Cotisant> iterator) {
            this.stk = new Stack<>();
            this.stk.push(iterator);
        }

        public boolean hasNext() {
            if (stk.empty())
                return false;
            else {
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
