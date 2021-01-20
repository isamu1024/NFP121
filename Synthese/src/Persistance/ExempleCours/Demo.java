package Persistance.ExempleCours;

public class Demo {

    public static void main(String[] args) {
        AuditeurCnam alex = new AuditeurCnam("alex");
        Unite Ang320 = new Unite("ANG320");
        Unite NFP121 = new Unite("NFP121");
        alex.addUnite(Ang320).addUnite(NFP121);

        Save save =  new Save(".\\src\\Persistance\\ExempleCours\\");

        try {
            save.sauvegarder("alex.ser", alex);
        }
        catch (Exception e){
            System.out.println("oups ! " + e.getMessage());
        }

        System.out.println(alex.toString());

    }
}
