package vip.rules;

public interface IRule<C,R>{
    
    /** Exécution d'une règle de la forme:
     * Si la condition est satisfaite alors la commande est exécutée.
     * if(condition.isSatisfied(context))
     *   return command.execute(result);
     *   
     * @param context l'entité
     * @parama result le résultat
     * @return le résultat de l'exécution
     */
  public R execute(C context, R result);
}