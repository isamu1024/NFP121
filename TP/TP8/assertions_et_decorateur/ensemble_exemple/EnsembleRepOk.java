package ensemble_exemple;

 
public class EnsembleRepOk extends Decorateur{
  
  public EnsembleRepOk( CollectionI c){
    super(c);
    assert c.repOk() : " repOk invalide !";
  }
 
  public void ajouter(int i){
    assert super.repOk() : " repOk invalide !";
    super.ajouter(i);
    assert super.repOk() : " repOk invalide !";   
  }
  public void ajouter(CollectionI c){
    assert super.repOk() : " repOk invalide !";
    super.ajouter(c);
    assert super.repOk() : " repOk invalide !";
  }
  public void retirer(int i){
    assert super.repOk() : " repOk invalide !";
    super.retirer(i);
    assert super.repOk() : " repOk invalide !";
  }
  public boolean contient(int i){
    assert super.repOk() : " repOk invalide !";
    boolean res = super.contient(i);
    assert super.repOk() : " repOk invalide !";   
    return res;
  }
  public int taille(){
    assert super.repOk() : " repOk invalide !";   
    int nombre = super.taille();
    assert super.repOk() : " repOk invalide !";
    return nombre;
  }
  public boolean equals(Object o){
    assert super.repOk() : " repOk invalide !";  
    boolean res = super.equals(o);
    assert super.repOk() : " repOk invalide !";
    return res;
  }
  public int hashCode(){
    assert super.repOk() : " repOk invalide !";      
    int res = super.hashCode();
    assert super.repOk() : " repOk invalide !";
    return res;
  }
  public Object af(){ // une fonction d'abstraction avec effet de bord
    assert super.repOk() : " repOk invalide !";    
    Object res = super.af();
    assert super.repOk() : " repOk invalide !"; 
    return res;
  }
}
