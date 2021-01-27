package Question1;

import java.util.concurrent.Flow;

public class Message {
    private final String source;
    private final String content;

    public Message(String source, String content) {
        this.source = source;
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return "<" + source + ", " + content + ">";
    }
}

