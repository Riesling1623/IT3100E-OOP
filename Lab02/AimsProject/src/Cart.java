public class Cart {
    
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    
    // Create method addDigitalVideoDisc(DigitalVideoDisc disc) to add an item to the list, check current quantity to assure that the cart is not full.
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        // Find the first blank slot in the cart
        int indexBlank = 0;
        while (itemsOrdered[indexBlank] != null && indexBlank < itemsOrdered.length){
            indexBlank++;
        }
        
        // If having blank slot
        if (indexBlank < itemsOrdered.length){
            itemsOrdered[indexBlank] = disc;
            System.out.println("The disc has been added.");
            qtyOrdered++;
        }
        // If the cart is full 
        else {
            System.out.println("The cart is almost full.");
        }
    }

    // Add a list of DVD to the current cart
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for (DigitalVideoDisc disc: dvdList){
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // Remove Disc
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int indexRemove = -1;

        // The cart is blank
        if (qtyOrdered == 0){
            System.out.println("The cart is blank.");
        } else {
            // Search the index of the removed disc 
            for (int i = 0; i < qtyOrdered; i++){
                if (itemsOrdered[i].equals(disc)){
                    indexRemove = i;
                    break;
                }
            }
            
            // Detete from the itemOrdered array.
            if (indexRemove != -1){
                for (int i = indexRemove; i < qtyOrdered; i++){
                    itemsOrdered[i] = itemsOrdered[i+1];
                }
                qtyOrdered--;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("The disc has been removed.");
            } 
            // The disc has not been found
            else {
                System.out.println("Not found this disc");
            }
        }
    }

    // Create the totalCost() method which returns the total cost in the current cart.
    public float totalCost(){
        float sumCost = 0.0f;
        for (DigitalVideoDisc disc: itemsOrdered){
            // Check if the current element in the array is null or not before accessing its cost property using the getCost() method.
            if (disc != null){
                sumCost += disc.getCost();
            }
        }
        return sumCost;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (DigitalVideoDisc disc : itemsOrdered){
            if (disc != null){
                System.out.println(disc.toString());
            } else {
                break;
            }
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    
}
