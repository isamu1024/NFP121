package Observer.ExempleCours1;

import java.util.List;

/**
 *  Interface simple pour les Observateurs
 */
public interface Observateur{
    public void update(String s);
    public List<String> getNofications();
}
