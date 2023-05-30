public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyStore;

    public void addDVD(DigitalVideoDisc disc){
        int indexBlank = 0;
        while (itemsInStore[indexBlank] != null && indexBlank < itemsInStore.length){
            indexBlank++;
        }

        if (indexBlank < itemsInStore.length){
            itemsInStore[indexBlank] = disc;
            // System.out.println("Added.");
            qtyStore++;
        }
    }

    public void removeDVD(DigitalVideoDisc disc){
        int indexRemove = -1;
        for (int i = 0; i < qtyStore; i++){
            if (itemsInStore[i].equals(disc)){
                indexRemove = i;
                break;
            }
        }

        if (indexRemove != -1){
            for (int i = indexRemove; i < qtyStore; i++){
                itemsInStore[i] = itemsInStore[i+1];
                // System.out.println("Removed.");
            }
            qtyStore--;
            itemsInStore[qtyStore] = null;
        }
    }
}
