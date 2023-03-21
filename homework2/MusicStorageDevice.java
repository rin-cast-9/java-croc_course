import java.util.Vector;

public abstract class MusicStorageDevice {

    // this class represents a device that contains a music and that can be put in a playback device to playback the music

    protected String type = null; // a field that contains the type of the music storage device
    protected Vector <Music> music = new Vector <Music> (); // a field that contains musics recorded on the music storage device

    public String get_type () { // type-field getter
        return this.type;
    }

    public void set_type (String type) { // type-field setter
        this.type = type;
    }

}