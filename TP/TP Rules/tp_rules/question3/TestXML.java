package question3;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import question2.MacroCommand;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Décrivez votre classe TestXML ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestXML extends junit.framework.TestCase {

    public void testExportXml() throws Exception {
        String path = "testExport" + ".xml";
        File file = new File(path);
        Element racine = new Element("Rule");
        Document document = new Document(racine);

        Rule<Integer, Integer> rule = new Rule<>(new EstInferieur(4), new Inc(1));

        XmlDecorator<Integer, Integer> ruleDec = new XmlDecorator<>(rule, racine);

        ruleDec.execute(3, 3);

        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        out.output(document, new FileOutputStream(path));
    }

    public void testExportXMLRules() throws Exception{

        String path = "testExportXmlRules" + ".xml";
        File file = new File(path);
        Element racine = new Element("Rules");
        Document document = new Document(racine);

        Rules<Integer,Integer> rules = new Rules<>();
        RuleI<Integer,Integer> rule = new XmlDecorator<>(new Rule<>(new EstInferieur(4), new Inc(1)), racine);
        rules.add(rule).add(rule);

        rules.execute(0,0);

        Element tree = new Element("rule");


        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        out.output(document, new FileOutputStream(path));

    }
}
