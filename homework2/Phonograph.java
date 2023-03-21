public class Phonograph extends PlaybackDevice {

    // this class is derived from playback device class to inherit all its properties
    // this class represents the phonograph type of playback devices

    Phonograph () {
    }

    @Override
    public boolean isPlayable (MusicStorageDevice musicStorageDevice) { // overriding isPlayable method to make it match with the corresponding type of music storage devices
        if (musicStorageDevice instanceof Vinyl) {
            return true;
        }
        return false;
    }

}
