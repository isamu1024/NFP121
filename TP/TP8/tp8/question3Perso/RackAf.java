package question3Perso;

public class RackAf<T> extends RackDecorator<T>{

    public RackAf(Irack<T> rack) {
        super(rack);
    }

    @Override
    public void addItem(T t) throws Exception {
        int freeSlots = super.freeSlots();
        super.addItem(t);
        Colis[][] af = (Colis[][]) super.af();

        int count = super.getNbCol() * super.getColCapacity();

        try{
            Colis current;

                for (int i = 0; i < super.getNbCol(); i++)
                    for (int j = 0; j < super.getColCapacity(); j++) {
                        current = af[i][j];
                        if (current != null)
                            count--;
                    }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assert (count == freeSlots -1);
    }

    @Override
    public T removeItem(int col, int slot) throws Exception {
        int freeSlots = super.freeSlots();
        T item = super.removeItem(col, slot);
        Colis[][] af = (Colis[][]) super.af();
        int count = super.getNbCol() * super.getColCapacity();

        try {
            Colis current;

                for (int i = 0; i < super.getNbCol(); i++)
                    for (int j = 0; j < super.getColCapacity(); j++) {
                        current = af[i][j];
                        if (current != null)
                            count--;
                    }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assert (count == freeSlots + 1);
        return item;
    }

    @Override
    public boolean estPlein(){

        return this.freeSlots() == 0;
    }

    @Override
    public int getNbCol() {
        int nbCol = super.getNbCol();
        Colis[][] af = (Colis[][]) super.af();
        int afNbcol = af.length;
        assert nbCol == afNbcol;
        return nbCol;
    }

    @Override
    public int getColCapacity(){
        int colCapacity = super.getColCapacity();
        Colis[][] af = (Colis[][]) super.af();
        int afColCapacity = af[0].length;
        assert afColCapacity == colCapacity;

        return colCapacity;
    }

    @Override
    public T getColis(int col, int slot) throws Exception {
        Colis colis = (Colis) super.getColis(col, slot);
        Colis[][] af = (Colis[][]) super.af();
        assert colis.getName().equals(af[col][slot].getName());

        return (T) colis;
    }

    @Override
    public int freeSlots(){
        int freeSlots = super.freeSlots();
        int afFreeSlots = super.getNbCol() * super.getColCapacity();
        Colis[][] af = (Colis[][]) super.af();

        try {
            Colis current;

            for (int i = 0; i < super.getNbCol(); i++)
                for (int j = 0; j < super.getColCapacity(); j++) {
                    current = af[i][j];
                    if (current != null)
                        afFreeSlots--;
                }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assert freeSlots == afFreeSlots;
        return  freeSlots;
    }
}
