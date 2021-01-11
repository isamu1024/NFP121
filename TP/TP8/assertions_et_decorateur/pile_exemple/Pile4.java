package pile_exemple;


public class Pile4<T> implements PileI<T>{
    protected Maillon<T> stk;
    /** la capacite de la pile */
    private int   capacite;
    /** le nombre */
    private int nombre;

    /** Classe interne contenant chaque element de la chaine
     */
    protected class Maillon<T> implements Cloneable{
        private T element;
        private Maillon suivant;

        public Maillon(T element, Maillon suivant){
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant(){
            return this.suivant;
        }

        public T element(){
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException{
            //System.out.println("clone");
            Maillon m = (Maillon)super.clone();
            return m;
        }
    }

    /** Creation d'une pile.
     * @param taille la taille de la pile, la taille doit etre > 0
     */
    public Pile4(int taille){
        if(taille<=0) taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    

    public void empiler(T o) throws PilePleineException{
        if(estPleine()) throw new PilePleineException();
        stk = new Maillon(o, stk);
        nombre++;
    }

    public T depiler() throws PileVideException{
        if(estVide())  throw new PileVideException();
        T elt = stk.element();
        stk = stk.suivant();
        nombre--;
        return elt;
    }

    public T sommet() throws PileVideException{
        if(estVide())  throw new PileVideException();
        return stk.element();
    }

    /** Effectue un test de l'etat de la pile.
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide(){
        return stk == null;
    }

    /** Effectue un test de l'etat de la pile.
     * @return vrai si la pile est pleine, faux autrement
     */   
    public boolean estPleine(){
        return capacite == nombre;
    }

    /** Retourne une representation en String d'une pile, 
     * contenant la representation en String de chaque element.
     * @return une representation en String d'une pile
     */ 
    public String toString(){
        Maillon m = this.stk;
        String s = "[";
        while(m!=null){
            s += m.element();
            m = m.suivant();
            if (m !=null) s+= ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o){
        if (o instanceof Pile4){
            Pile4 p = (Pile4)o;
            if(p.taille()==this.taille()  && p.capacite() == this.capacite()){
                Maillon mp = p.stk;
                for(Maillon m = stk; m!=null;m=m.suivant(),mp=mp.suivant())
                    if(!m.element().equals(mp.element())) return false;
                return true;
            }
        }
        return false;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Pile4 p = new Pile4(this.capacite());
        traversee(p,stk);
        return p;
    }

    private void traversee(Pile4 p, Maillon m){
        try{
            if(m!=null){
                traversee(p,m.suivant());
                p.empiler(m.element());
            }
        }catch(PilePleineException e){
        }
    }

    public int capacite(){
        return this.capacite;
    }

    public int hashCode(){
        return toString().hashCode();
    }

    public int taille(){
        return nombre;
    }

    public boolean repOk(){
        return (this.capacite >0) && 
               ((this.stk == null) ||
                     (this.stk!=null && true/*TODO*/));

    }
    public java.util.Stack<T> af(){
        return copie(stk); 
    }

    private java.util.Stack<T> copie(Maillon m){

        if(m==null){
            return new java.util.Stack<T>();
        }else{
            java.util.Stack<T> stk = copie(m.suivant());
            stk.push((T)m.element);
            return stk;
        }

    }
}

