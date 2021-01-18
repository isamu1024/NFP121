package Observer.ExempleCours1;

import java.util.HashSet;

/**
 *  Sujet concret, il encapsulera les observateurs inscrits
 */
public class SujetConcret extends Subject {
    private int value;

    public SujetConcret(){
        super.observateurs = new HashSet<>();
    }

    public void setValue(int value){
        this.value = value;
        super.notification(this.value);
    }

}
