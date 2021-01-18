import java.util.*;

public class Client
{
    public static void main(String[] args){
        Stack<Integer> stk = new Stack<>();
        Visiteur<Integer> vi = new VisiteurCalcul();
        Visiteur<String> vp = new VisiteurInst();
        // 3
        Expression e1 = new Nombre(3);
        int resultat = e1.accepter(vi);
        System.out.println("e1 : " + e1.accepter(vp) + " = " + resultat);

        // 3 + 2
        Expression e2 = 
            new Addition(
                new Nombre(3),
                new Nombre(2));
        resultat = e2.accepter(vi);
        System.out.println("e2: " + e2.accepter(vp) + " = " + resultat);

        // 3 + (3 + 2)
        Expression e3 = new Addition(e1,e2);
        resultat = e3.accepter(vi);
        System.out.println("e3: " + e3.accepter(vp) + " = " + resultat);

        //(3 + 3) + 5
        Expression e4 = new Addition(
                new Addition(e1,e1),
                new Nombre(5)
            );
        resultat = e4.accepter(vi);
        System.out.println("e4: " + e4.accepter(vp) + " = " + resultat);

        Expression e5 = new Addition( e4, e3);
        resultat = e5.accepter(vi);
        System.out.println("e5: " + e5.accepter(vp) + " = " + resultat);
    }

    public static void main2(){

        Composant c1 = new Label();
        Composant c2 = new Label();

        Panneau p1 = new Panneau();
        p1.ajouter(c1);
        p1.ajouter(c2);
        p1.dessiner();

        Panneau p2 = new Panneau();
        p2.ajouter(p1);
        p2.ajouter(new Label());
        p2.dessiner();
    }

}
