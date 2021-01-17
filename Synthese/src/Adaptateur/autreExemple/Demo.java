package Adaptateur.autreExemple;

public class Demo {

    public static void main(String[] args) {

        // Une cheville ronde va dans un trou rond :
        TrouRond trou = new TrouRond(5);
        ChevilleRonde ChevilleR = new ChevilleRonde(5);

        if (trou.convient(ChevilleR))
            System.out.println("Ok");

        AdaptateurChevilleCarre adaptateur = new AdaptateurChevilleCarre(new ChevilleCarree(2));

        if (trou.convient(adaptateur)) ;
            System.out.println("Ok");

    }
}
