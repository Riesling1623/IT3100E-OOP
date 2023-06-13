package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Media;


public class Cart {
    
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Add Media
    public void addMedia(Media media){
        boolean checkExist = itemsOrdered.contains(media);
        if (!checkExist){
            itemsOrdered.add(media);
        }
    }

    // Remove Media
    public void removeMedia(Media media){
        boolean checkExist = itemsOrdered.contains(media);
        if (checkExist){
            itemsOrdered.remove(media);
        }
    }

    // Create the totalCost() method which returns the total cost in the current cart.
    public float totalCost(){
        float sumCost = 0.0f;
        for (Media media : itemsOrdered){
            sumCost += media.getCost();
        }
        return sumCost;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered){
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void search(int id){
        boolean checkId = false;
        for (Media media : itemsOrdered){
            if (id == media.getId()){
                System.out.println(media.toString()); 
                checkId = true;
                break;
            }
        }

        if (checkId == false){
            System.out.println("No match is found.");
        }
    }

    public void search(String title){
        boolean checkTitle = false;
        for (Media media: itemsOrdered){
            if (title.equals(media.getTitle())){
                System.out.println(media.toString());
                checkTitle = true;
                break;
            }
        }

        if (checkTitle == false){
            System.out.println("No match is found.");
        }
    }

    public void filterCartById(int id){
        List<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered){
            if (media.getId() == id){
                filteredList.add(media);
            }
        }
        displayFilteredList(filteredList);
    }

    public void filterCartByTitle(String title){
        List<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered){
            if (media.getTitle().equalsIgnoreCase(title)){
                filteredList.add(media);
            }
        }
        displayFilteredList(filteredList);
    }

    public void displayFilteredList(List<Media> filteredList){
        if (filteredList.isEmpty()){
            System.out.println("No media found.");
        } else {
            System.out.println("Filtered medias: ");
            System.out.println("--------------------------------");
            for (Media media : filteredList){
                System.out.println(media.toString());
            }
            System.out.println("--------------------------------");
        }
    }

    public void sortCartByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Medias in cart have been sorted by title.");
    }

    public void sortCartByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Medias in cart have been sorted by cost.");
    }

    public Media searchCart(String title){
        for (Media media : itemsOrdered){
            if (media.getTitle().equalsIgnoreCase(title)){
                return media;
            }
        }
        return null;
    }

    public void placeOrder(){
        itemsOrdered.clear();
    }
}
