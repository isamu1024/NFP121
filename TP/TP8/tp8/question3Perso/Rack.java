package question3Perso;

import java.util.List;

public abstract class Rack<T> implements Irack<T> {

protected List<List<T>> rackStructure ;
protected int nbCol;
protected int colCapacity;

public boolean estPlein(){
    return this.freeSlots() == 0;
}

public int getColCapacity(){
    return this.colCapacity;
}

public int getNbCol(){
    return this.nbCol;
}

public T getColis (int col, int slot) throws Exception{

    if (col > nbCol || slot > colCapacity)
        throw new Exception();

    return rackStructure.get(col).get(slot);
}

public int freeSlots() {
    int free = 0;

    for (List<T> liste : rackStructure)
        free += colCapacity - liste.size();

    return free;
}

}
