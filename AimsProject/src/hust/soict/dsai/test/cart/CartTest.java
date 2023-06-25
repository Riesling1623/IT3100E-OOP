package hust.soict.dsai.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        try {
            cart.addMedia(dvd1);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        try {
            cart.addMedia(dvd2);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        try {
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }

        cart.removeMedia(dvd3);
        // Test the print method
        cart.print();

        // Test the search method

        // Search by id
        cart.search(1);

        // Search by title
        cart.search("Aladin");
    }
}
