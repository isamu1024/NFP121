package question2;
import question1.*;

/**
 * Décrivez votre classe FahrenheitCelsius ici.
 * 
 * @author Alexandre Moro   
 * @version 11/10/2020
 */
public class FahrenheitCelsius {

    /**
     * le point d'entrée de cette application, dont le commentaire est à compléter
     *
     * @param args ...
     */
    public static void main(String[] args) {

        for (String item : args) {
            int fahrenheit = 0;
            float celsius = 0;
            try {

                fahrenheit = Integer.parseInt(item);
                celsius = fahrenheitEnCelsius(fahrenheit);

                System.out.println(fahrenheit + "\u00B0F -> " + celsius + "\u00B0C");

            } catch (NumberFormatException nfe) {

                System.out.println("error : " + nfe.getMessage());

            }
        }
    }

    public static float fahrenheitEnCelsius(int f) {

        float resultat = (int)(((f - 32) * 5/9f)*10) / 10.0f;
       
        return resultat;

    }
}
