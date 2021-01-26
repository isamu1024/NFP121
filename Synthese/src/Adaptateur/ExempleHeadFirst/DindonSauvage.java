package Adaptateur.ExempleHeadFirst;

/**
 * Un dindon ordinaire :p
 */
public class DindonSauvage implements Dindon{

    @Override
    public void gloutouter() {
        System.out.println("GlouGlou");
    }

    @Override
    public void voler() {
        System.out.println("Je ne vole pas loin");
    }
}
