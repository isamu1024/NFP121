package question3;

import question3.tp3.*;

import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class IHMCalculette extends JFrame {
    public IHMCalculette() {
        super("IHM Calculette");
        // Creates a new, initially invisible Frame with the specified title.
        
        PileModele<Integer> modele = new PileModele<Integer>(new Pile2<Integer>(5)); // construction du modele
        
        Controleur controle = new Controleur(modele); // on construit le controleur
        
        Vue vue = new Vue(modele);
        Vue2 vue2 = new Vue2(modele);// on construit la vue

        setLayout(new GridLayout(2, 1));
        add(vue);
        add(vue2);
        add(controle);
        pack();
        setLocation(200,200);
        setVisible(true);

    }

    public static void main(String[] args){
        new IHMCalculette();
    }
}
