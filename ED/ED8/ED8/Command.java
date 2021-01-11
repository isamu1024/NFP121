public abstract class Command{

  public abstract void execute() throws Exception;
  public abstract void undo() throws Exception;
  
  public void executeTransaction() throws Exception{
    try{
      execute();
    }catch(Exception e){
      undo();
      throw e;
    }
  }
}