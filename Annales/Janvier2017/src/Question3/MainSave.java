package Question3;

import Question1.*;

public class MainSave {
    public static void main(String[] args){
        PubSubI pubsub = new PubSubPersistent("pubsub");
        SimpleSubscriber a = new SimpleSubscriber(pubsub, "a");
        SimpleSubscriber b = new SimpleSubscriber(pubsub, "b");
        SimpleSubscriber c = new SimpleSubscriber(pubsub, "c");
        Message msg = new Message("p1","test");
        pubsub.publish(new String[]{"a","b"}, msg);
    }
}
