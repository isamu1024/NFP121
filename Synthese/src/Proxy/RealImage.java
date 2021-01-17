package Proxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk(){
        System.out.println("Chargement de " + this.fileName);
    }

    public void displayImage(){
        System.out.println("Affichage de " + this.fileName);
    }
}
