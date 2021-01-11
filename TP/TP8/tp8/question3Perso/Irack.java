package question3Perso;

public interface Irack<T> {
    void addItem(T t) throws Exception;

    T removeItem(int col, int slot) throws Exception;

    boolean estPlein();

    int getNbCol();

    int getColCapacity();

    T getColis(int col, int slot) throws Exception;

    int freeSlots();

    Object[][] af();

    boolean repOk();
}
