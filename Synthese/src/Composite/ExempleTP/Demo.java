package Composite.ExempleTP;

public class Demo {

    public static void main(String[] args) {

        Visiteur<Integer>  ve = new VisiteurEvaluation();
        Visiteur<String> vs = new VisiteurString();

        Expression a = new Addition(new Nombre(33), new Nombre(2));
        System.out.println(a.accepter(ve));
        System.out.println(a.accepter(vs));

        Expression b = new Soustraction(new Addition(new Nombre(2), new Nombre(2)), new Nombre(4) );
        System.out.println(b.accepter(ve));
        System.out.println(b.accepter(vs));

    }
}
