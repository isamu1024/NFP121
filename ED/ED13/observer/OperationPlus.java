package observer;

import operations.Operation;

public class OperationPlus implements Operation<Nombre,Resultat>{
    
    private int operande ; 
    
    public void setOperande (int operande) {
        this.operande = operande;
    }
    
    @Override
    public void execute(Nombre n, Resultat r) {
      r.setValeur(n.getValeur()+operande);   
    }
   
}
