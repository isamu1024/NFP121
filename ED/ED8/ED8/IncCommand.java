public class IncCommand extends Command{

    private Entier entier;
    private Caretaker caretaker;

    public IncCommand(Entier e){

        this.entier = e;
        this.caretaker = new Caretaker();

    }

    @Override
    public void execute() throws Exception {

        this.caretaker.setMemento(entier.saveToMemento());
        this.entier.inc();


    }

    @Override
    public void undo() throws Exception {

        entier.restoreFromMemento(caretaker.getMemento());
    }
}
