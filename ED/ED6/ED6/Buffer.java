public class Buffer implements CollectionI{
  private int[] data;
  private int in,out;
  private int capacity;
  private int size;
  
  public Buffer(int capacity){
    this.capacity = capacity;
    this.data = new int[capacity]; 
  }
  public void put(int i) throws BufferFullException{
    if(full()) throw new BufferFullException();
    data[in] = i;
    in = (in+1)%capacity;
    size++;
  }
  public int get() throws BufferEmptyException{
    if(empty()) throw new BufferEmptyException();
    int value = data[out];
    out = (out+1)%capacity;
    size--;
    return value;
  }
  public boolean empty(){
    return size==0;
  }
  public boolean full(){
    return size==capacity;
  }
  public int size(){ return size;}
  public int capacity(){ return capacity;}
}