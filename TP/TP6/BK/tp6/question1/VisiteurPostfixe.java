package question1;

public class VisiteurPostfixe extends VisiteurParDefaut<String> {

    private Contexte c;

    public VisiteurPostfixe(Contexte c) {
        this.c = c;
    }

    // à compléter
    // aucun "warning, de type unsafe à la compilation ne doit apparaître

    public Contexte contexte() {
        return c;
    }

}
