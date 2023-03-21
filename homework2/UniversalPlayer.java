public class UniversalPlayer extends PlaybackDevice {
    
    // this class is derived from playback device class to inherit all its properties
    // this class represents the universal player type of playback devices

    UniversalPlayer () {
    }

    @Override
    public boolean isPlayable(MusicStorageDevice musicStorageDevice) { // overriding isPlayable method to make it match with all the types of music storage devices as it's universal player
        return true;
    }

}
