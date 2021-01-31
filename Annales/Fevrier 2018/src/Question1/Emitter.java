package Question1;


public class Emitter implements EmitterI{

    private ContentBasedRouterI router;
    private String name;
    
    public Emitter(String name){
        this.name = name;
    }

   public void setRouter(ContentBasedRouterI router){
     this.router = router;
   }   
  
    public String getName(){
        return name;
    }
    
    public int sendMessage(String msg){
      return router.sendMessage(msg);
    }

}
