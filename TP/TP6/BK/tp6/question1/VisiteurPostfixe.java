package question1;

public class VisiteurPostfixe extends VisiteurParDefaut<String> {

    private Contexte c;

    public VisiteurPostfixe(Contexte c) {
        this.c = c;
    }

    // � compl�ter
    // aucun "warning, de type unsafe � la compilation ne doit appara�tre

    public Contexte contexte() {
        return c;
    }

}
