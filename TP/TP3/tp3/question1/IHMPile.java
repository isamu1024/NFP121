package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// pour le comportement attendu depuis votre répertoire
// exécuter cette commande tp3>appletviewer tp3.html
public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private Pile p;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    
    // Reprise des méthodes vues en TP2, on entoure les actions empiler et depiler par de try catch pour gêrer les exceptions
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("empiler")){
            
            try{

                p.empiler(donnee.getText()); // on empile la donnée contenue dans le textBox

                contenu.setText(p.toString()); // appelle de la méthode toString de la classe Pile pour afficher le contenu

            } catch(PilePleineException ppe) { // gestion de l'exception

                contenu.setText(p.toString() + " estPleine !"); // on renvoi est pleine si la capacité est atteinte

            }

        }else{
            // idem mais avec depiler()
            try {
                sommet.setText(p.depiler().toString());

                contenu.setText(p.toString());

            } catch(PileVideException pve) {
                contenu.setText( p.toString() + " estVide !");
            }

        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
