public class SetValeurCommand extends Command {

    private final Entier entier;
    private final Caretaker caretaker;

    private int valeur;

    public SetValeurCommand(Entier e) {
        this.entier = e;
        this.caretaker = new Caretaker();
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public void execute() throws Exception {
        this.caretaker.setMemento(entier.saveToMemento());
        entier.setValeur(valeur);
    }

    @Override
    public void undo() throws Exception {
        entier.restoreFromMemento(caretaker.getMemento());
    }
}
