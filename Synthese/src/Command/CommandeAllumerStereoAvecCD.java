package Command;

public class CommandeAllumerStereoAvecCD implements Commande {
    Stereo stereo;

    public CommandeAllumerStereoAvecCD(Stereo stereo){
        this.stereo = stereo;
    }

    public void executer(){
        stereo.marche();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
