package question3Perso;

public abstract class RackDecorator<T> implements Irack<T>{

    private Irack<T> rack;

    public RackDecorator(Irack<T> rack){
        this.rack = rack;
    }

    @Override
    public void addItem(T t) throws Exception {
        rack.addItem(t);
    }

    @Override
    public T removeItem(int col, int slot) throws Exception {
        return rack.removeItem(col, slot);
    }

    @Override
    public boolean estPlein() {
        return rack.estPlein();
    }

    @Override
    public int getNbCol() {
        return rack.getNbCol();
    }

    @Override
    public int getColCapacity() {
        return rack.getColCapacity();
    }

    @Override
    public T getColis(int col, int slot) throws Exception {
        return rack.getColis(col, slot);
    }

    @Override
    public int freeSlots() {
        return rack.freeSlots();
    }

    @Override
    public Object[][] af(){
        return rack.af();
    }

    @Override
    public boolean repOk() {
        return rack.repOk();
    }
}
