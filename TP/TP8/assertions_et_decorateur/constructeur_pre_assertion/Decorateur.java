package constructeur;



public abstract class Decorateur{
    private Integer i;
  
    public Decorateur(Integer i){
      System.out.println(" appel du Decorateur : " + i);
       this.i = i;
    }

 
}
