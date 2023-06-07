package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, director, length);
    }

    public String toString() {
        return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    public boolean isMatch(String titleString){
        if (titleString.equals(getTitle())){
            return true;
        }
        return false;
    }
}
