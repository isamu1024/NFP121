package Adaptateur.exempleCours;

public class Demo {
    public static void main(String[] args) {
        Prise prise = new Adaptateur(new PriseRCA());

        prise.afficher();
        // output : Depuis la prise RCA
    }
}
