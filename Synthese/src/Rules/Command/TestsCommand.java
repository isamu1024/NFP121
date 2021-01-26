package Rules.Command;

public class TestsCommand extends junit.framework.TestCase {

    public void testSimpleAvecDesEntiers() throws Exception {
        Command<Integer> inc = new Inc();
        Command<Integer> dec = new Dec();
        Command<Integer> print = new PrintCommand<>();
        Integer i = 2;
        assertEquals(Integer.valueOf(3), inc.execute(i));
        assertEquals(Integer.valueOf(1), dec.execute(i));
        MacroCommand<Integer> plus4 = new MacroCommand<>();
        plus4.add(inc).add(inc).add(inc).add(inc).add(print);
        Integer res = 0;
        assertEquals(Integer.valueOf(4), plus4.execute(res));
        assertEquals("(inc -> inc -> inc -> inc -> print)", plus4.interpreter());
        MacroCommand<Integer> plus2 = new MacroCommand<Integer>();
        plus2.add(inc).add(inc);
        MacroCommand<Integer> plus6 = new MacroCommand<Integer>();
        plus6.add(plus2).add(plus2).add(plus2);
        assertEquals("((inc -> inc) -> (inc -> inc) -> (inc -> inc))", plus6.interpreter());
    }

    public void testSimpleAvecUneException() throws Exception {
        Command<Integer> dec = new Dec();
        Command<Integer> print = new PrintCommand<>();
        MacroCommandException<Integer> moins4 = new MacroCommandException<Integer>();
        moins4.setExceptionCmd(print);
        moins4.add(dec).add(dec).add(dec).add(dec);
        moins4.execute(2);
    }

    public static class Inc extends Command<Integer> {
        public Integer execute(Integer i) {
            return new Integer(i + 1);
        }

        public String interpreter() {
            return "inc";
        }
    }

    public static class Dec extends Command<Integer> {
        public Integer execute(Integer i) {
            if (i == 0) throw new RuntimeException();
            return new Integer(i - 1);
        }

        public String interpreter() {
            return "dec";
        }
    }
}
