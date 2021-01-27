package Question1;


import java.util.*;


public class PubSubImpl implements PubSubI {

    private final String name;
    Set<SubscriberI> subscribers;


    public PubSubImpl(String name) {
        this.subscribers = new HashSet<>();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean publish(String name, Message message) {
        boolean res = false;
        for (SubscriberI sub : this.subscribers) {
            if (sub.getName().equals(name)) {
                try {
                    sub.onMessage(message);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public int publish(String[] names, Message message) {
        int number = 0;

        for (String name : names) {
            for (SubscriberI sub : this.subscribers) {
                if (sub.getName().equals(name)) {
                    try {
                        sub.onMessage(message);
                        number++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return number;
    }

    public boolean subscribe(SubscriberI subscriber) {
        return this.subscribers.add(subscriber) && subscriber.addPubSub(this);
    }

    public Iterator<SubscriberI> iterator() {
        return this.subscribers.iterator();
    }
}

