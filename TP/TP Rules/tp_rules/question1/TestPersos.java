package question1;


/**
 * Décrivez votre classe TestPersos ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestPersos extends junit.framework.TestCase
{
    public void testOneOf(){
        assertFalse(new OneOf<>().add(new FALSE()).add(new FALSE()).add(new FALSE()).isSatisfiedBy(null));
        assertTrue(new OneOf<>().add(new FALSE()).add(new TRUE()).add(new FALSE()).isSatisfiedBy(null));
        assertTrue(new OneOf<>().add(new TRUE()).add(new FALSE()).add(new FALSE()).isSatisfiedBy(null));
        assertTrue(new OneOf<>().add(new TRUE()).add(new TRUE()).add(new TRUE()).isSatisfiedBy(null));
    }

    public void testOnlyOne(){
        assertFalse(new OnlyOne<>().add(new FALSE()).add(new FALSE()).add(new FALSE()).isSatisfiedBy(null));
        assertTrue(new OnlyOne<>().add(new FALSE()).add(new TRUE()).add(new FALSE()).isSatisfiedBy(null));
        assertTrue(new OnlyOne<>().add(new TRUE()).add(new FALSE()).add(new FALSE()).isSatisfiedBy(null));
        assertFalse(new OnlyOne<>().add(new TRUE()).add(new TRUE()).add(new TRUE()).isSatisfiedBy(null));
        assertTrue(new OnlyOne<>().add(new TRUE()).isSatisfiedBy(null));
        assertTrue(new OnlyOne<>().add(new TRUE()).add(new FALSE()).isSatisfiedBy(null));
        assertFalse(new OnlyOne<>().add(new TRUE()).add(new FALSE()).add(new TRUE()).isSatisfiedBy(null));
    }

    public void testTableDeVeriteNoneNone(){
        CompositeSpecification<Object> none = new None<>().add(new FALSE()).add(new FALSE()).add(new FALSE());
        assertTrue(none.toString()+"!= true ???",none.isSatisfiedBy(null));
        none = new None<>().add(new TRUE()).add(none).add(none);
        boolean test = none.isSatisfiedBy(null);
        assertFalse(none.toString()+"!= false ???",none.isSatisfiedBy(null));
        // System.out.println("\tnone : " + none);
        none= new None<>().add(none).add(none);
        assertFalse(none.toString()+"!= false ???",none.isSatisfiedBy(null));
        none=new None<>().add(new TRUE()).add(new FALSE()).add(none);
        assertFalse(none.toString()+"!= false ???",none.isSatisfiedBy(null));
        none=new None<>().add(new FALSE()).add(new FALSE()).add(new FALSE());
        assertTrue(none.isSatisfiedBy(null));
        // System.out.println("\tnone : " + none);
        CompositeSpecification<Object> nonne = new None<>().add(none);//.add(none).add(none);
        // System.out.println("\tnonne : " + nonne);
        assertTrue(nonne.isSatisfiedBy(null));
        assertFalse(new None<>().add(new FALSE()).add(new TRUE()).add(nonne).isSatisfiedBy(null));
        assertFalse(new None<>().add(new TRUE()).add(new FALSE()).add(new FALSE()).add(nonne).isSatisfiedBy(null));

        assertTrue(new None<>().add(none).add(none).isSatisfiedBy(null));
        assertTrue(new None<>().add(new FALSE()).add(none).add(none).isSatisfiedBy(null));

        CompositeSpecification<Object> nonnette = new None<>().add(nonne);
        assertTrue(nonnette.toString() +"!=true ???",nonnette.isSatisfiedBy(null));

        nonne = new None<>().add(none).add(none).add(none);
        //System.out.println("\tnonne : " + nonne);
        assertTrue(nonne.toString() +"!=true ???",nonne.isSatisfiedBy(null));

        CompositeSpecification<Object> oneOf = new OneOf<>().add(new FALSE()).add(new TRUE()).add(new FALSE());
        nonne = new None<>().add(none).add(oneOf).add(none);
        //System.out.println("\tnonne : " + nonne);
        assertFalse(nonne.toString() +"!=false ???", nonne.isSatisfiedBy(null));

    }

}

