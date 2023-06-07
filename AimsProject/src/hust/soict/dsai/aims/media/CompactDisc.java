package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // Getters
    public String getArtist() {
        return artist;
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
    public CompactDisc(String title, String category, float cost, String director){
        super(title, category, cost, director);
    }
    public CompactDisc(String title, String category, float cost, String director, int length){
        super(title, category, cost, director, length);
    }
    public CompactDisc(String title, String category, float cost, String director, int length, String artist){
        super(title, category, cost, director, length);
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
}
