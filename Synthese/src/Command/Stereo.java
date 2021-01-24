package Command;

public class Stereo {

    public Stereo(){}

    public void marche(){
        System.out.println("Stereo allumee");
    }

    public void arret(){
        System.out.println("Stereo eteinte");
    }

    public void setCD(){
        System.out.println("Stereo allumee");
    }

    public void setDvd(){
        System.out.println("Mode DVD selectionne");
    }

    public void setRadio(){
        System.out.println("Mode radio selectionne ");
    }

    public void setVolume(int volume){
        System.out.println("Volume" + String.valueOf(volume) + "selectionne");
    }

}
