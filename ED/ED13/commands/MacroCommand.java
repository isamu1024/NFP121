package commands;


/**
 * Décrivez votre classe MacroCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MacroCommand<T,R> extends Command<T,R>{
  protected Command<T,R>[]   commands;
 
  public void setCommands(Command<T,R>[] commands){
      this.commands = commands;
    }

    public void execute(T t,R r){
       try{
           if(condition!=null && condition.estSatisfaite(t)){
               if(operation!=null)operation.execute(t,r);
               for( Command<T,R> cmd : commands){
                   cmd.execute(t,r);
                }
           }
       }catch(RuntimeException e){
           if(exception!=null) exception.execute(t,r);
           throw e;
        }
   }
}
