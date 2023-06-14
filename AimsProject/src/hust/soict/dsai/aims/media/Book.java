package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    
    private List<String> authors = new ArrayList<String>();

    public Book(){
        super();
    }

    public Book(String title){
        super(title);
    }

    public Book(String title, String category, float cost){
        super(title, category, cost);
    }

    // Add author
    public void addAuthor(String authorName){
        boolean checkExist = authors.contains(authorName);
        if (!checkExist){
            authors.add(authorName);
        }
    }

    // Remove author
    public void removeAuthor(String authorName){
        boolean checkExist = authors.contains(authorName);
        if (checkExist){
            authors.remove(authorName);
        }
    }
    
    public String toString() {
        return getId() + ". DVD - " + getTitle() + " - " + getCategory() + ": " + getCost() + " $";
    }
}
