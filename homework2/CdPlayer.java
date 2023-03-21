public class CdPlayer extends PlaybackDevice {

    // this class is derived from playback device class to inherit all its properties
    // this class represents the cd player type of playback devices

    CdPlayer () {
    }

    @Override
    public boolean isPlayable(MusicStorageDevice musicStorageDevice) { // overriding isPlayable method to make it match with the corresponding type of music storage devices
        if (musicStorageDevice instanceof Cd) {
            return true;
        }
        return false;
    }
    
}
