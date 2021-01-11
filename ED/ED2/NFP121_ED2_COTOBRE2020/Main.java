public class Main{
    public static void main (String [] args){
        Entier e;
        for (String s : args) {
            try{
                e = Entier.parseEntier(s);
            } catch (NumberFormatException exc) {
                System.out.println(s + " engendre une exception !");
            }
        }
    }
}
