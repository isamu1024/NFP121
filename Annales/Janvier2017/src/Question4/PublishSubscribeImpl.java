package Question4;

import Question1.*;

import java.util.*;

public class PublishSubscribeImpl implements PublishSubscribeI {

    private final Map<String, List<SubscriberI>> topicsMembers;

    public PublishSubscribeImpl() {
        this.topicsMembers = new HashMap<>();
    }

    public int publish(String topic, Message message) {
        int res = 0;
            for (SubscriberI s : this.topicsMembers.get(topic)){
                try {
                    s.onMessage(message);
                    res++;
                }catch (Exception e){

                }
            }

        return res;
    }

    public boolean subscribe(String topic, SubscriberI subscriber) {
        if (!this.topicsMembers.containsKey(topic)) {
            List<SubscriberI> subscribers = new ArrayList<>();
            subscribers.add(subscriber);
            this.topicsMembers.put(topic, subscribers);
            return true;
        }

        if (this.topicsMembers.containsKey(topic) && !this.topicsMembers.get(topic).contains(subscriber)) {
            this.topicsMembers.get(topic).add(subscriber);
            return true;
        }

        return false;
    }

    public Iterator<String> iterator() {
        return this.topicsMembers.keySet().iterator();
    }

    public List<SubscriberI> getSubscribers(String topic) {
            return this.topicsMembers.get(topic);
    }
}
