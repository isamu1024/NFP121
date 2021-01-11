package question3Perso;

import java.util.ArrayList;
import java.util.List;

public class RackContinu<T> extends Rack<T> {
    /**
     * Creat an empty rack for Santa
     *
     * @param col      number if subrack
     * @param capacity number of slot that can store an item
     */
    public RackContinu(int col, int capacity) {
        super.nbCol = col;
        super.colCapacity = capacity;
        super.rackStructure = new ArrayList<>();

        for (int i = 0; i < col; i++) {
            rackStructure.add(new ArrayList<>(colCapacity));
        }
    }

    /**
     * Add an object to the rack
     * The rack is stayed organized and do not allow empty cell between object (work like a stack)
     *
     * @param t object to add
     * @throws Exception if rack is full
     */
    @Override
    public void addItem(T t) throws Exception {
        if (estPlein())
            throw new Exception();

        for (int col = 0; col < nbCol; col++)
            if (rackStructure.get(col).size() < colCapacity) {
                rackStructure.get(col).add(t);
                break;
            }
    }

    /**
     * Return the item at the specified location
     * Ensure that there is no empty slot between items
     *
     * @param col  Column where the slot is
     * @param slot Slot containing the object
     * @return Object contained in the slot
     */
    @Override
    public T removeItem(int col, int slot) throws Exception {
        T item;

        if (col >= this.nbCol || slot >= this.colCapacity)
            throw new Exception();

        if (rackStructure.get(col).get(slot) == null)
            throw new Exception();

        item = rackStructure.get(col).get(slot);
        rackStructure.get(col).remove(slot);
        List<T> temp = new ArrayList<T>();
        for (List<T> liste : rackStructure) {
            temp.addAll(liste);
            liste.clear();
        }
        for (T t : temp)
            this.addItem(t);
        return item;
    }

    /**
     * The rack can be represented by an array between each operation
     * @return an equivalent of the rack in the form of an arrayList
     */
    @Override
//    public List<Object> af() {
//        List<Object> t = new ArrayList<>(this.nbCol * this.colCapacity);
//        for (List<T> liste : rackStructure)
//            t.addAll(liste);
//        return t;
//    }

    public Object[][] af() {
        Object[][] af = new Colis[this.nbCol][this.colCapacity];

        for (int i = 0; i < rackStructure.size(); i++)
            for (int j = 0; j < rackStructure.get(i).size(); j++ )
                af[i][j] = rackStructure.get(i).get(j);

        return af;
    }

    @Override
    public boolean repOk() {
        return true;
    }

}
