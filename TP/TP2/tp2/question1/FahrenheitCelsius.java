package question1;

/**
 * Décrivez votre classe FahrenheitCelsius ici.
 * 
 * @author Alexandre Moro
 * @version 11/10/2020
 */
public class FahrenheitCelsius {

    /**
     * le point d'entrée de cette application, dont le commentaire est à
     * compléter
     * 
     * @param args : Les données en °F a convertir
     *   
     */
    public static void main(String[] args) {

        for (String item : args) {

            int fahrenheit = Integer.parseInt(item);
            float celsius = fahrenheitEnCelsius(fahrenheit);

            System.out.println(fahrenheit + "\u00B0F -> " + celsius + "\u00B0C");
        }														
    }

    /**
     * la méthode à compléter.
     * 
     * @param f la valeur en degré Fahrenheit
     * @return la conversion en degré Celsius
     */
    public static float fahrenheitEnCelsius(int f) {

        return (int)(((f - 32) * 5/9f)*10) / 10.0f;
      
    }

}
