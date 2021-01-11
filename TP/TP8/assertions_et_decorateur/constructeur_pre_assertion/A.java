package constructeur;



public class A extends Decorateur{
 
    public A(Integer i){
        super(i==i?pre_A(i):null);
    }

    private static Integer pre_A(Integer i){
      System.out.println("avant l'appel de super() ??? " + i);
      assert i != null && i > 0 : " pre A failed...";
      return i;
    }
 
}
