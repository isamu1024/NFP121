package Observer.ExempleCours1;

import java.util.ArrayList;
import java.util.List;

public class ObservateurConcret implements Observateur {

    private final List<String> notifications;

    public ObservateurConcret() {
        this.notifications = new ArrayList<>();
    }

    public void update(String message) {
        this.notifications.add(message);
    }

    public List<String> getNofications() {
        return this.notifications;
    }


}
