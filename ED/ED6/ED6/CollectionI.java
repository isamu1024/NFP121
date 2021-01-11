public interface CollectionI{

  public void put(int i) throws FullException;
  public int get() throws EmptyException;
  public boolean full();
  public boolean empty();
  public int size();
  public int capacity();
}
