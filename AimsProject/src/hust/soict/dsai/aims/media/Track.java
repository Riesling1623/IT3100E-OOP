package hust.soict.dsai.aims.media;

public class Track {
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
        this.title = title;
        this.length = length;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

}
