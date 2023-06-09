package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
    private String artist;

    private List<Track> tracks = new ArrayList<Track>();

    // Getters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Constructors
    public CompactDisc(){
        super();
    }
    public CompactDisc(String title){
        super(title);
    }
    public CompactDisc(String title, String category, float cost){
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, float cost, String director, int length){
        super(title, category, cost, director, length);
    }
    public CompactDisc(String title, String category, float cost, String director, int length, String artist){
        super(title, category, cost, director, length);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String artist){
        super(title, category, cost);
        this.artist = artist;
    }

    // Add track
    public void addTrack(Track track){
        boolean checkExist = tracks.contains(track);
        if (!checkExist){
            tracks.add(track);
        } else {
            System.out.println("This track is already in the list of tracks.");
        }
    }

    // Remove track
    public void removeTrack(Track track){
        boolean checkExist = tracks.contains(track);
        if (checkExist){
            tracks.remove(track);
        } else {
            System.out.println("This track does not exist in the list of tracks.");
        }
    }

    // Get the length of CD
    public int getLength(List<Track> tracks){
        int lengthCD = 0;
        for (Track track : tracks){
            lengthCD += track.getLength();
        }

        return lengthCD;
    }

    public void play(){
        for (Track track : tracks){
            track.play();
        }
    }

    public String playGUI() throws PlayerException{
        if (this.getLength() > 0){
            String playCD = "";
            for (Track track: tracks){
                try {
                    playCD += (track.playGUI() + "\n");
                } catch (PlayerException e){
                    playCD += (track.playGUI() + "\n" + e.getMessage());
                }
            }
            return playCD;
        } else {
            throw new PlayerException("Error: CD length is non-positive!");
        }
    }

    public String toString() {
        return getId() + ". CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " - "  + getArtist() + ": " + getCost() + " $";
    }
}
