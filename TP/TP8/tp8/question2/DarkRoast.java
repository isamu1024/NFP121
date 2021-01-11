package question2;
/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public class DarkRoast extends Beverage {
	public DarkRoast() {
		super.description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}
