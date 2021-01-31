package Question1;

public class ContainsFilter implements FilterI {

    private String expr = "";

    public ContainsFilter(String expr){
        this.expr = expr;
    }

    @Override
    public boolean accept(String msg) {
         return msg.contains(expr);
    }
}
