package Question1;

import java.util.*;
import java.util.logging.Filter;

public class ContentBasedRouter implements ContentBasedRouterI {

    private final Map<ReceiverI, Set<FilterI>> filters;
    private final Map<ReceiverI, Boolean> receivers;
    private final Set<ReceiverI> recException;

    private final String name;

    public ContentBasedRouter(String name) {
        this.name = name;
        this.filters = new HashMap<>();
        this.receivers = new HashMap<>();
        this.recException = new HashSet<>();
    }

    public ContentBasedRouter addReceiver(ReceiverI receiver) {
        this.receivers.put(receiver, false);
        this.filters.put(receiver, new HashSet<>());
        return this;
    }

    public ContentBasedRouter addFilter(ReceiverI receiver, FilterI filter) {
        this.filters.get(receiver).add(filter);
        return this;
    }

    public ContentBasedRouter removeReceiver(ReceiverI receiver) {
        this.receivers.remove(receiver);
        this.filters.remove(receiver);
        return this;
    }

    public ContentBasedRouter setEnabled(ReceiverI receiver) {
        this.receivers.put(receiver, true);
        return this;
    }

    public ContentBasedRouter setDisabled(ReceiverI receiver) {
        this.receivers.put(receiver, false);
        return this;
    }

    public int sendMessage(String msg) {

        int number = 0;

        for (ReceiverI receiver : this.receivers.keySet()) {
            if (this.receivers.get(receiver)) {
                Boolean res = true;
                for (FilterI filter : this.filters.get(receiver)) {
                    res &= filter.accept(msg);
                }
                if (res) {
                    try {
                        receiver.receive(msg);
                        number++;
                    } catch (Exception e) {
                        setDisabled(receiver); // Ne pas l'oublier !!!
                        this.recException.add(receiver);
                    }
                }
            }
        }
        return number;
    }

    public Iterator<ReceiverI> iterator() {
        return this.recException.iterator();
    }

    public Set<ReceiverI> getReceiversException() {
        return this.recException;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "";
    }
}

