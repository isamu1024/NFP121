package question1;

public class VisiteurEvaluation extends VisiteurParDefaut<Integer> {

    private Contexte c;

    public VisiteurEvaluation(Contexte c) {
        this.c = c;
    }

    // � compl�ter
    // aucun "warning, de type unsafe � la compilation ne doit appara�tre

    public Contexte contexte() {
        return c;
    }

}
