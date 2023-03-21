public class Music {

    // this class represents the information about a music
    
    String artist = null; // a field that contains an artist's name 
    String title = null; // a field that contains a music title

    Music () { // default constructor
    }

    Music (String artist, String title) { // constructor that sets an artist's name and music's title
        this.artist = artist;
        this.title = title;
    }

    public String get_artist () { // artist-field getter
        return this.artist;
    }

    public void set_artist (String artist) { // artist-field setter
        this.artist = artist;
    }

    public String get_title () { // title-field getter
        return this.title;
    }

    public void set_title (String title) { // title-field setter
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s by %s%n", this.title, this.artist);
    }

}
