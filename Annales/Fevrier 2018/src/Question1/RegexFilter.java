package Question1;

public class RegexFilter implements FilterI{

    private String regex;

    public RegexFilter(String regex){
        this.regex = regex;
    }

    @Override
    public boolean accept(String msg) {
        return msg.matches(regex);
    }
}
