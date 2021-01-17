package Proxy;

public class ProxyImage implements Image {

    private String fileName;
    private Image image;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    public void displayImage(){
        if (image == null)
            image = new RealImage(fileName); // Chargement sur demande

        image.displayImage();
    }
}
