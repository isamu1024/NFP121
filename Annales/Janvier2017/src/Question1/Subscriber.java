package Question1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Subscriber implements SubscriberI {

    Set<PubSubI> pubSubs;

    private String name;

    public Subscriber(String name){
        this.name = name;
        this.pubSubs = new HashSet<>();
    }

    public String getName(){
        return this.name;
    }
    public List<PubSubI> getPubSubList(){
        return new ArrayList<>(this.pubSubs);
    }

    public boolean addPubSub(PubSubI pubsub){
        return this.pubSubs.add(pubsub);
    }

}
