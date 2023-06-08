package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
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
    
}
