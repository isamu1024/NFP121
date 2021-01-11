package question3Perso;

public class RackRepOk<T>  extends RackDecorator<T> {

    public RackRepOk(Irack<T> rack) {
        super(rack);
    }

    @Override
    public void addItem(T t) throws Exception{
        assert super.repOk();
        super.addItem(t);
        assert super.repOk();
    }

    public T removeItem(int col, int slot) throws Exception {
        assert super.repOk();
        T item = super.removeItem(col, slot);
        assert super.repOk();
        return item;
    }

    public boolean estPlein(){
        assert super.repOk();
        boolean b = super.estPlein();
        assert super.repOk();
        return b;
    }

    public int getNbCol() {
        assert super.repOk();
        int res = super.getNbCol();
        assert super.repOk();
        return res;
    }

    public int getColCapacity() {
        assert super.repOk();
        int res = super.getColCapacity();
        assert super.repOk();
        return res;
    }

    public T getColis(int col, int slot) throws Exception{
        assert super.repOk();
        T item = super.getColis(col, slot);
        assert super.repOk();
        return  item;
    }

    public int freeSlots(){
        assert  super.repOk();
        int res = super.freeSlots();
        assert super.repOk();
        return res;
    }
}
