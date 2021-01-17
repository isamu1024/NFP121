package question1;

import java.util.*;

public class Dest {

    private final String name;
    private final Map<String, Boolean> messages;

    public Dest(String name) {

        this.name = name;
        this.messages = new TreeMap<>();

    }

    public String getName(){
        return this.name;
    }

    public void recept(String message){
        this.messages.put(message, false);
    }

    public List<String> getUnreadMessage() {

        List<String> unreadMessages = new ArrayList<>();

        for (String s : messages.keySet()) {
            if (messages.get(s) == false) {
                unreadMessages.add(s);
                messages.put(s, true);
            }
        }

        return unreadMessages;

    }

    public List<String> getAllMessages() {

        List<String> allMessages = new ArrayList<>();

        for (String message : this.messages.keySet()) {
            allMessages.add(message);
//            this.messages.put(message, true);
        }

        return allMessages;

    }

}
