package soundsystem.properties;

import java.util.List;

import soundsystem.CompactDisc;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.print("Playing " + title + " by " + artist + "\r\n");
        for (String track : tracks) {
            System.out.print("-Track: " + track + "\r\n");
        }
    }

}
