package vip.rules;


public interface ICommand<E,R>{
  public R execute(E entity, R result);
}
