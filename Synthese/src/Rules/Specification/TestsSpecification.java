package Rules.Specification;

public class TestsSpecification extends junit.framework.TestCase {


    public void testSimpleAvecDesEntiers() {
        Specification<Integer> pair = new EstPair();
        Specification<Integer> inf = new EstInferieur(10);
        Specification<Integer> sup = new EstSuperieur(5);
        assertTrue(pair.isSatisfiedBy(4));
        assertEquals("estPair", pair.interpreter());
        assertTrue(inf.isSatisfiedBy(4));
        assertEquals("estInferieur_a_10", inf.interpreter());
        CompositeSpecification<Integer> et = new And<Integer>();
        assertFalse(et.add(sup).add(pair).add(inf).isSatisfiedBy(14));
        assertEquals("and(estSuperieur_a_5, estPair, estInferieur_a_10)", et.interpreter());
        CompositeSpecification<Integer> ou = new Or<Integer>();
        assertTrue(ou.add(sup).add(pair).add(inf).isSatisfiedBy(14));
        assertEquals("or(estSuperieur_a_5, estPair, estInferieur_a_10)", ou.interpreter());
        Specification<Integer> nonOu = new Not(ou);
        assertFalse(nonOu.isSatisfiedBy(14));
        assertEquals("not(or(estSuperieur_a_5, estPair, estInferieur_a_10))", nonOu.interpreter());
        Specification<Integer> nonEt = new Not(et);
        assertTrue(nonEt.isSatisfiedBy(14));
        assertEquals("not(and(estSuperieur_a_5, estPair, estInferieur_a_10))", nonEt.interpreter());
        CompositeSpecification<Integer> onlyOne = new OnlyOne<Integer>();
        assertTrue(onlyOne.add(sup).add(pair).add(inf).isSatisfiedBy(15));
        CompositeSpecification<Integer> none = new None<Integer>();
        assertTrue(none.add(sup).add(pair).isSatisfiedBy(1));
    }

    private static class EstPair extends Specification<Integer> {
        public boolean isSatisfiedBy(Integer i) {
            return i % 2 == 0;
        }

        public String interpreter() {
            return "estPair";
        }
    }

    private static class EstSuperieur extends Specification<Integer> {
        private final int valeur;

        public EstSuperieur(int valeur) {
            this.valeur = valeur;
        }

        public boolean isSatisfiedBy(Integer i) {
            return i > valeur;
        }

        public String interpreter() {
            return "estSuperieur_a_" + valeur;
        }
    }

    public static class EstInferieur extends Specification<Integer> {
        private final int valeur;

        public EstInferieur(int valeur) {
            this.valeur = valeur;
        }

        public boolean isSatisfiedBy(Integer i) {
            return i < valeur;
        }

        public String interpreter() {
            return "estInferieur_a_" + valeur;
        }
    }

    private static class EstImpair extends Not<Integer> {
        public EstImpair() {
            super(new EstPair());
        }

        public String interpreter() {
            return "estImpair";
        }
    }
}

