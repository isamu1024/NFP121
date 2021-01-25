package observer;

import commands.Command;

public class CommandeNombre extends Command<Nombre, Resultat>{
    
    @Override
   public void execute(Nombre nombre,Resultat resultat){
       assert condition !=null && operation !=null;
       try{
           if(condition.estSatisfaite(nombre)){
               operation.execute(nombre,resultat);
           }
       }catch(RuntimeException e){
           if(exception!=null) exception.execute(nombre,resultat);
           throw e;
        }
   }
    
}
