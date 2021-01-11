package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class JPanelListe2 extends JPanel implements ActionListener, ItemListener {

    private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("décroissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private JButton boutonAnnuler = new JButton("annuler");

    private TextArea texte = new TextArea();

    private List<String> liste;
    private Map<String, Integer> occurrences;

    private CareTaker listeEtats = new CareTaker();

    public JPanelListe2(List<String> liste, Map<String, Integer> occurrences) {
        this.liste = liste;
        this.occurrences = occurrences;

        cmd.setLayout(new GridLayout(3, 1));

        cmd.add(afficheur);
        cmd.add(saisie);

        panelBoutons.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(boutonRechercher);
        panelBoutons.add(boutonRetirer);
        panelBoutons.add(new JLabel("tri du texte :"));
        panelBoutons.add(ordreCroissant);
        panelBoutons.add(ordreDecroissant);
        panelBoutons.add(boutonOccurrences);
        panelBoutons.add(boutonAnnuler);
        cmd.add(panelBoutons);

        if(liste!=null && occurrences!=null){
            afficheur.setText(liste.getClass().getName() + " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }else{
            texte.setText("la classe Chapitre2CoreJava semble incomplète");
        }

        boutonAnnuler.setEnabled(false);

        setLayout(new BorderLayout());
        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);

        // Réagie a la validation par la touche return
        saisie.addActionListener(this);

        // ActionListener sur les boutons
        boutonRetirer.addActionListener(this);
        boutonOccurrences.addActionListener(this);
        boutonAnnuler.addActionListener(this);

        ordreCroissant.addItemListener(this);
        ordreDecroissant.addItemListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            boolean res = false;

            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie) {
                res = liste.contains(saisie.getText());
                Integer occur = occurrences.get(saisie.getText());
                afficheur.setText("résultat de la recherche de : "
                    + saisie.getText() + " -->  " + res);
            } else if (ae.getSource() == boutonRetirer) {

                res = retirerDeLaListeTousLesElementsCommencantPar(saisie
                    .getText());
                afficheur
                .setText("résultat du retrait de tous les éléments commençant par -->  "
                    + saisie.getText() + " : " + res);
            } else if (ae.getSource() == boutonOccurrences) {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ??? ");
            } else if (ae.getSource() == boutonAnnuler){

                restoreFromMemento((Memento)listeEtats.getMemento());
            }
            texte.setText(liste.toString());

        } catch (Exception e) {
            afficheur.setText(e.toString());
        } finally {
            //System.out.println(listeEtats.getSize());
            updateUi();
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == ordreCroissant){
            listeEtats.addMemento(saveToMemento());
            Collections.sort(liste);
        }
        else if (ie.getSource() == ordreDecroissant) {
            listeEtats.addMemento(saveToMemento());
            TriDecroissant triD = new TriDecroissant();
            Collections.sort(liste, triD);
        }

        updateUi();

        texte.setText(liste.toString());
    }

    public void updateUi(){
        if(listeEtats.getSize() == 0) {
            boutonAnnuler.setEnabled(false);
        } else {
            boutonAnnuler.setEnabled(true);
        }}

    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {

        if (prefixe.equals("") || prefixe == null)
            return false;

        boolean resultat = false;
        boolean sauvegardeEtat = false;

        Iterator it = occurrences.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String, Integer> entree = (Map.Entry)it.next();

            if (entree.getKey().startsWith(prefixe)){

                if (entree.getValue() != 0){
                    
                    if (!sauvegardeEtat) {
                        listeEtats.addMemento(saveToMemento());
                        sauvegardeEtat = true;
                    }
                        
                    occurrences.replace(entree.getKey(), 0);
                }

                Iterator listIt = liste.iterator();

                while (listIt.hasNext()){
                    if(listIt.next().equals(entree.getKey())){

                        listIt.remove();
                        resultat = true;
                    }

                }

            }
        }

        texte.setText(liste.toString());
        return resultat;
    }

    public Object saveToMemento()
    {
        return new Memento(liste, occurrences);
    }

    public void restoreFromMemento(Memento m)
    {

        Memento memento = m;

        liste = memento.getListe();
        occurrences = memento.getOccurences();

    }

    private class TriDecroissant implements Comparator<String>{

        @Override
        public int compare(String a, String b){

            return (a.compareToIgnoreCase(b) * -1);

        } 

    }

    /**
     * Classe interne Memento utilisée pour sauvegarder les état de la liste et de la Hashmap
     */

    private class Memento{

        private List<String> MementoListe; 
        private Map<String, Integer> MementoOccurrences;

        public Memento(List<String> liste,Map<String, Integer> occurrences) {
            MementoListe = new LinkedList<String>(liste);
            MementoOccurrences = new HashMap<String, Integer>(occurrences);            
        }

        public List<String> getListe(){
            return MementoListe;
        }

        public Map<String, Integer> getOccurences(){
            return MementoOccurrences;
        }

    }

}
