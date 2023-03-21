public class CassetteDeck extends PlaybackDevice {

    // this class is derived from playback device class to inherit all its properties
    // this class represents the cassette deck type of playback devices
    
    CassetteDeck () {
    }

    @Override
    public boolean isPlayable (MusicStorageDevice musicStorageDevice) { // ovverriding isPlayable method to make it match with the corresponding type of music storage devices
        if (musicStorageDevice instanceof Tape) {
            return true;
        }
        return false;
    }
    
}
