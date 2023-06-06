package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book(){

    }

    // Getter
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
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
    
}
