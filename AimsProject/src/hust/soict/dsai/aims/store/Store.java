package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    // Add Media
    public void addMedia(Media media){
        boolean checkExist = itemsInStore.contains(media);
        if (!checkExist){
            itemsInStore.add(media);
        }
    }

    // Remove Media
    public void removeMedia(Media media){
        boolean checkExist = itemsInStore.contains(media);
        if (checkExist){
            itemsInStore.remove(media);
        }
    }

    public void displayStore() {
        System.out.println("Items in the store:");
        System.out.println("--------------------------------");
        for (Media media : itemsInStore){
            System.out.println(media.toString());
        }
        System.out.println("--------------------------------");
    }

    public Media search(String title){
        for (Media media : itemsInStore){
            if (media.getTitle().equalsIgnoreCase(title)){
                return media;
            }
        }
        return null;
    }
}
