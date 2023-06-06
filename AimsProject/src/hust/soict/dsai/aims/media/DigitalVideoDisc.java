package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media{
    private String director;
    private int length;

    // private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }

    public String toString() {
        return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + this.director + " - " + this.length + ": " + getCost() + " $";
    }

    public boolean isMatch(String titleString){
        if (titleString.equals(getTitle())){
            return true;
        }
        return false;
    }
}
