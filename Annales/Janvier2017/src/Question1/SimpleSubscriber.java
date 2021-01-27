package Question1;


public class SimpleSubscriber extends Subscriber {

    public SimpleSubscriber(String name){
        super(name);
    }

    public SimpleSubscriber(PubSubI pubSub, String name){
        super(name);
        pubSub.subscribe(this);
    }

    public void onMessage(Message message) throws Exception{
        System.out.println(getName() + " : " + message);
    }

}