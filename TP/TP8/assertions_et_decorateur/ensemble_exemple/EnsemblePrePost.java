package ensemble_exemple;

 


public class EnsemblePrePost extends Decorateur{
  
  protected boolean pre_ajouter(int i){
    return true;
  }
  protected boolean post_ajouter(int i){
    return (tailleAvant+1 == super.taille() && !dejaPresent && super.contient(i)) ||
           (tailleAvant == super.taille() && dejaPresent && super.equals(ensembleAvant));
  }
  public void ajouter(int i){
    initVariables(i);
    assert pre_ajouter(i) : "pre assertion ajouter invalide !";
    super.ajouter(i);
    assert post_ajouter(i) : "post assertion ajouter invalide !";  
  }
  
  
//   public EnsemblePrePost( CollectionI c){
//     super(c);
//     assert c.repOk();
//   }
  
  public EnsemblePrePost( CollectionI c){
    // pré-assertion d'un constructeur de décorateur ?
    // pas d'instruction possible ici avant l'appel du constructeur de la super classe
    // comment alors vérifier une pré-assertion ? ... avec le code ci-dessous ... 
    // rien de plus élégant pour l'instant, a voir par introspection...
    super(c==c?pre_EnsemblePrePost(c):null);
    assert c.repOk();
  }
  
  protected static CollectionI pre_EnsemblePrePost( CollectionI c){
    // ici une pré assertion de type décoration
    assert c!=null : " pre assertion EnsemblePrePost invalide";
    return c;
  }
  
  private int      tailleAvant=-1;
  private boolean  dejaPresent;
  private Ensemble ensembleAvant;
  
  private void initVariables(){
    ensembleAvant = new Ensemble();
    for(int i : this)
      ensembleAvant.ajouter(i);
      
    tailleAvant = super.taille();  
    dejaPresent = false;
  }
  
  private void initVariables(int i){
    initVariables();
    this.dejaPresent = super.contient(i);
  }
  

  
  
  protected boolean pre_ajouter(CollectionI c){
    if(c==null) return false;
    return true;
  }
  protected boolean post_ajouter(CollectionI c){

    for(int i : c)
      if(!super.contient(i))return false;
    return true;
  }
  public void ajouter(CollectionI c){
    initVariables();
    assert pre_ajouter(c) : "pre assertion ajouter invalide !";
    super.ajouter(c);
    assert post_ajouter(c) : "post assertion ajouter invalide !";
  }
  
  protected boolean pre_retirer(int i){

    return true;
  }
  protected boolean post_retirer(int i){
    return (tailleAvant == super.taille() && !dejaPresent && super.equals(ensembleAvant)) ||
           (tailleAvant-1 == super.taille() && dejaPresent );
  }
  public void retirer(int i){
    initVariables(i);
    assert pre_retirer(i)  : "pre assertion retirer invalide !";
    super.retirer(i);
    assert post_retirer(i) : "post assertion retirer invalide !";
  }
  
  protected boolean pre_contient(int i){  
    return true;
  }
  protected boolean post_contient(int i){
    return this.equals(ensembleAvant);
  }
  public boolean contient(int i){
    initVariables(i);
    assert pre_contient(i) : "pre assertion contient invalide !";
    boolean res = super.contient(i);
    assert post_contient(i) : "post assertion contient invalide !";
    return res;
  }
  
  protected boolean pre_taille(){
    return (super.taille()>=0);
  }
  protected boolean post_taille(){
    return (super.taille()>=0 && tailleAvant==super.taille() && super.equals(ensembleAvant));
  }
  public int taille(){
    initVariables();
    assert pre_taille() : "pre assertion taille invalide !";
    int res = super.taille();
    assert post_taille() : "post assertion taille invalide !";
    return res;
  }
  
  protected boolean pre_equals(Object o){
    return o!= null & o instanceof CollectionI;
  }
  protected boolean post_equals(Object o){
    return super.equals(ensembleAvant);
  }
  public boolean equals(Object o){
    initVariables();
    assert pre_equals(o)  : "pre assertion equals invalide !";
    boolean res = super.equals(o);
    assert post_equals(o)  : "post assertion equals invalide !";
    return res;
  }
  
  protected boolean pre_hashCode(){
    return true;
  }
  protected boolean post_hashCode(){
    return this.equals(ensembleAvant);
  }
  
  public int hashCode(){
    initVariables();
    assert pre_hashCode()  : "pre assertion hashCode invalide !";
    int res = super.hashCode();
    assert post_hashCode()  : "post assertion hashCode invalide !";    
    return res;
  }
}
