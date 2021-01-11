package tutoMVC;

import java.util.EventObject;

public class VolumeChangedEvent extends EventObject {

    private int newVolume;

    public VolumeChangedEvent(Object source, int newVol) {

        super(source);
        this.newVolume = newVolume;
    }

    public int getNewVolume() {
        return newVolume;
    }

}
