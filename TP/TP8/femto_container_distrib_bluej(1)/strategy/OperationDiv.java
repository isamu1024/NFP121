package strategy;


/**
 * D�crivez votre classe OperationDiv ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class OperationDiv implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 / num2;
   }
}