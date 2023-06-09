package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private int length;
    private String director;

    // Constructors
    public Disc(){
        super();
    }
    public Disc(String title){
        super(title);
    }
    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }
    public Disc(String title, String category, float cost, String director){
        super(title, category, cost);
        this.director = director;
    }
    public Disc(String title, String category, float cost, String director, int length){
        super(title, category, cost);
        if (length < 0){
            System.out.println("Invalid length.");
        } else {
            this.director = director;
            this.length = length;
        }
    }

    // Getters
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        if (length < 0){
            System.out.println("Invalid length.");
        } else {
            this.length = length;
        }
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public String toString(){
        return null;
    }
}
