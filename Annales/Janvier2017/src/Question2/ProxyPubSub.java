package Question2;

import Question1.*;

import java.util.ArrayList;
import java.util.List;

public class ProxyPubSub extends PubSubImpl implements PubSubI {

    private List<String> users;

    public ProxyPubSub(String name, List<String> users) {
        super(name);
        this.users = new ArrayList<>(users);
    }

    @Override
    public boolean publish(String name, Message message) {
        if (users.contains(message.getSource()))
            super.publish(name,message);

        return false;
    }

    @Override
    public int publish(String[] names, Message message) {
        if (users.contains(message.getSource()))
            return super.publish(names, message);
        return 0;
    }



}
