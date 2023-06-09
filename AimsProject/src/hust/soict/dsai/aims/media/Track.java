package hust.soict.dsai.aims.media;

import java.util.Objects;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    // Constructors
    public Track() {
        super();
    }
    public Track(String title) {
        this.title = title;
    }
    public Track(String title, int length) {
        if (length < 0){
            System.out.println("Invalid length.");
        }
        else {
            this.title = title;
            this.length = length;
        }
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public void play(){
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public String playGUI() throws PlayerException{
        if (this.getLength() > 0){
            return "Playing track: " + this.getTitle() + " - Track length: " + this.getLength() + "\n";
        } else {
            throw new PlayerException("ERROR: Track's length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Track)){
            return false;
        }
        Track track = (Track) o;
        return Objects.equals(title, track.title) && length == track.length;
    }
}
