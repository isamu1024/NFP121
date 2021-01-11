package question1;

/**
 * D�crivez votre classe FahrenheitCelsius ici.
 * 
 * @author Alexandre Moro
 * @version 11/10/2020
 */
public class FahrenheitCelsius {

    /**
     * le point d'entr�e de cette application, dont le commentaire est �
     * compl�ter
     * 
     * @param args : Les donn�es en �F a convertir
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
     * la m�thode � compl�ter.
     * 
     * @param f la valeur en degr� Fahrenheit
     * @return la conversion en degr� Celsius
     */
    public static float fahrenheitEnCelsius(int f) {

        return (int)(((f - 32) * 5/9f)*10) / 10.0f;
      
    }

}
