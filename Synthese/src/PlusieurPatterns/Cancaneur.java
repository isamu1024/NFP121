package PlusieurPatterns;

import PlusieurPatterns.Observer.CouacObservable;

/**
 * Cette fois, les Canards
 * vont implémenter une interface Cancaneur. Ainsi, nous saurons quels sont
 * les objets du simulateurs qui peuvent cancaner(), comme les colverts, les
 * mandarins, les appelants… et il se pourrait même que le canard en plastique
 * viennent pointer son nez.
 */

/**
 * nous devons faire en sorte que tous les Cancaneurs implémentent l'interface observable
 */
public interface Cancaneur extends CouacObservable {
    public void cancaner();
}
