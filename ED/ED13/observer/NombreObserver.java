package observer;

import java.util.Observable;
import java.util.Observer;

public class NombreObserver implements Observer{
    
    private String nom;
    private Observable src;
    
   public void setNom( String nom) {
    this.nom=nom;   
    }
    
    public Observable getSource() {
        return src;
    }
    
    @Override
    public void update (Observable src, Object o) {
        System.out.println(nom + "src : "+src + " update");
        this.src = src;
    }
}
