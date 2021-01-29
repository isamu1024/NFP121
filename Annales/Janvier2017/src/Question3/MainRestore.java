package Question3;

import Question1.*;

public class MainRestore {
    public static void main(String[] args){
        PubSubI pubsub = new PubSubPersistent("pubsub"); // les souscripteurs a, b et c ont été restitués
        Message msg = new Message("p1","test");
        pubsub.publish(new String[]{"a","b"}, msg); // a et b reçoivent le message
        msg = new Message("p1","test2");
        pubsub.publish(new String[]{"a","b","c","d"}, msg); // a, b et c reçoivent le message
    }
}
