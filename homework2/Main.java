public class Main {

    public static void main (String[] args) {

        // create some musics
        Music composition0 = new Music("bah", "symphony 5");
        Music composition1 = new Music("beethoven", "moonlight sonata");
        Music composition2 = new Music("tchaikovsky", "symphony 4");
        Music composition3 = new Music("mozart", "requiem");


        // create some playback devices
        Phonograph phonograph = new Phonograph();
        UniversalPlayer universalPlayer = new UniversalPlayer();


        // create some music storage devices
        Vinyl vinyl = new Vinyl();
        Tape tape = new Tape();
        FlashDrive flashDrive = new FlashDrive();


        // try to insert an incompatible storage device into a playback device
        phonograph.insert_music_storage_device(flashDrive); // devices types are incompatible, insertion failed

        // but universal player does the magic and it can take any type of storage devices
        universalPlayer.insert_music_storage_device(tape); // successfully inserted

        // although if we don't remove the device before trying inserting another one ...
        universalPlayer.insert_music_storage_device(flashDrive); // there's a device already inserted, cannot insert more

        // so we have to remove it first
        universalPlayer.remove_music_storage_device(); // successfully removed
        universalPlayer.insert_music_storage_device(flashDrive); // successfully inserted

        // let's try to record some tracks on the flash drive
        universalPlayer.record_composition(composition0);
        universalPlayer.record_composition(composition2);

        // print out the tracks that we've recorded 
        universalPlayer.print_music_list();

        // print out the info about the current state of the universal player
        universalPlayer.music_storage_device_info(); // not playing... 

        // then let's try to get the music played 
        universalPlayer.play_music(1);
        universalPlayer.music_storage_device_info(); // oh now it's playing


        // try to record some compositions on the vinyl
        phonograph.insert_music_storage_device(vinyl);
        phonograph.record_composition(composition1);
        phonograph.record_composition(composition3);
        phonograph.record_composition(composition2);
        phonograph.play_music(2);
        phonograph.music_storage_device_info();


        // then let's delete the first composition but to be on the safe side first let's print out the list of musics recorded
        phonograph.print_music_list();
        phonograph.erase_composition(1);
        phonograph.print_music_list();
        phonograph.play_music(0);
        phonograph.music_storage_device_info();

    }

}