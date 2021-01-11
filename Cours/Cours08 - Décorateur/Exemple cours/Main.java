
public class Main
{
   public static void main(String[] args){
    
       TexteI texte = new Texte("NFP 121");
       
       // Nous souhaitons décorer ce texte
       TexteI texte2 = new B(texte);
       
       // S'écrit également
       TexteI texte3 = new I( new B( new Texte("NSY102")));
       
       System.out.println(texte3.toHtml());
       
    }
}
