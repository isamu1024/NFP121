public class DecCommand extends Command {

    private final Entier entier;
    private final Caretaker caretaker;

    public DecCommand(Entier e) {

        this.entier = e;
        this.caretaker = new Caretaker();

    }

    @Override
    public void execute() throws Exception {

        this.caretaker.setMemento(entier.saveToMemento());
        this.entier.dec();

    }

    @Override
    public void undo() throws Exception {

        entier.restoreFromMemento(caretaker.getMemento());
    }
}



