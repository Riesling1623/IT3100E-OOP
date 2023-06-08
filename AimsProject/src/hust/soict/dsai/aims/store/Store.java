package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Add Media
    public void addMedia(Media media){
        itemsInStore.add(media);
    }

    // Remove Media
    public void removeMedia(Media media){
        boolean checkExist = itemsInStore.contains(media);
        if (checkExist){
            itemsInStore.remove(media);
        }
    }

}
