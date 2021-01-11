package question3;

import org.jdom.Element;

public class XmlDecorator<E, R> extends DecoratorRule<E, R>
{

    Element element = null;

    public XmlDecorator(RuleI<E,R> rule, Element e)
    {
        super(rule);
        this.element = e;
    }

    public XmlDecorator(){
        super();
    }

    @Override
    public R execute (E e, R r) throws Exception {

        Element rule = new Element("Rule");

        Element initValue = new Element("Valeur_initiale");
        initValue.setText(r.toString());
        rule.addContent(initValue);

        Element specification = new Element("Specification");
        specification.setText("si : " + ((Rule<E,R>) super.rule).getSpecification().toString());
        rule.addContent(specification);

        Element commande = new Element("Commande");
        commande.setText("alors : " + ((Rule<E,R>) super.rule).getCommand().toString());
        rule.addContent(commande);

        R result = super.rule.execute(e, r);

        Element resultat = new Element("Resultat");
        resultat.addContent(result.toString());
        rule.addContent(resultat);

        this.element.addContent(rule);

        return result;
    }
}
