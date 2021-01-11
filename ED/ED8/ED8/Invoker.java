import java.util.HashMap;
import java.util.Map;

/**
 * Décrivez votre classe Invoker ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Invoker {

    //private Command incCmd, decCmd, setCmd;

    private static Invoker instance;
    private final Map<String, Command> commands;

    // public Invoker(Command incCmd, Command decCmd, Command setCmd)
    private Invoker(){
//        this.incCmd = incCmd;
//        this.decCmd = decCmd;
//        this.setCmd = setCmd;

        this.commands = new HashMap<>();

    }

    // Singleton
    public static Invoker getInstance(){
        if(instance == null)
            instance = new Invoker();
        return  instance;
    }

    public void addCommande(String commandName, Command command){
        this.commands.put(commandName,command);
    }


    public void executeCommande(String commandName) throws Exception{
        if (this.commands.containsKey(commandName))
            this.commands.get(commandName).executeTransaction();
    }
//    public void inc() throws Exception{
//
//        this.incCmd.executeTransaction();
//
//    }
//
//    public void dec() throws Exception{
//
//        this.decCmd.executeTransaction();
//
//    }
//
//    public void set() throws Exception{
//
//        this.setCmd.executeTransaction();
//
//    }

}
