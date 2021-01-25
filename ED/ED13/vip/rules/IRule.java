package vip.rules;

public interface IRule<C,R>{
    
    /** Ex�cution d'une r�gle de la forme:
     * Si la condition est satisfaite alors la commande est ex�cut�e.
     * if(condition.isSatisfied(context))
     *   return command.execute(result);
     *   
     * @param context l'entit�
     * @parama result le r�sultat
     * @return le r�sultat de l'ex�cution
     */
  public R execute(C context, R result);
}