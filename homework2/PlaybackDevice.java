public abstract class PlaybackDevice {

    // this class represents a set of devices that can playback a music from music storage devices
    
    protected MusicStorageDevice music_storage_device = null; // a field that contains the music storage device having inserted in the playback device
    protected Music currentlyPlaying = null; // a field that contains the music currently playing

    public void insert_music_storage_device (MusicStorageDevice musicStorageDevice) { // inserts a music storage device in the playback device
        if (this.music_storage_device != null) {
            System.out.printf("there's already a device inserted, cannot insert more%n");
        }
        else if (this.isPlayable(musicStorageDevice) == true) {
            this.music_storage_device = musicStorageDevice;
            System.out.printf("successfully inserted%n");
        }
        else {
            System.out.printf("devices types are incompatible, insertion failed%n");
        }
    }

    public void remove_music_storage_device () { // removes the music storage device from the playback device
        System.out.printf("successfully removed%n");
        this.music_storage_device = null;
    }

    public void music_storage_device_info () { // prints out the info about the inserted music storage device 
        if (this.music_storage_device != null) {
            System.out.printf("inserted device is of %s type%n", this.music_storage_device.get_type());

            if (currentlyPlaying != null) {
                System.out.printf("currently playing: %s", currentlyPlaying).toString();
            }
            else {
                System.out.printf("not playing...%n");
            }
        }
        else {
            System.out.printf("no devices found%n");
        }
    }

    public void play_music (int index) { // plays the music from a list of musics by the given index
        this.currentlyPlaying = this.music_storage_device.music.get(index);
    }

    public void stop_music () {
        this.currentlyPlaying = null;
    }

    public Music[] get_music () { // gets musics recorded on the music storage device
        int musics_count = this.music_storage_device.music.size();
        Music[] musics = new Music[musics_count];

        for (int i = 0; i < musics_count; ++ i) {
            musics[i] = this.music_storage_device.music.get(i);
        }

        return musics;
    }

    public void print_music_list () { // prints out musics recorded on the music storage device
        int size = this.music_storage_device.music.size();

        for (int i = 0; i < size; ++ i) {
            System.out.printf("%3d   %s", i, this.music_storage_device.music.get(i).toString());
        }
    }

    public void record_composition (Music music) { // records a music on the music storage device
        this.music_storage_device.music.addElement(music);
    }

    public void erase_composition (int index) { // erases a music from the music storage device by the given index
        if (currentlyPlaying == this.music_storage_device.music.get(index)) {
            currentlyPlaying = null;
        }
        this.music_storage_device.music.removeElementAt(index);
    }

    abstract public boolean isPlayable (MusicStorageDevice musicStorageDevice); // checks if the inserted music storage device can be played back by the playback device 


}
