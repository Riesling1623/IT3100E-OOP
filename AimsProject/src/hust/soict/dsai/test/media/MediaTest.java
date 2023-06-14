package hust.soict.dsai.test.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Create some media here
        // for example: cd, dvd, book
        CompactDisc cd = new CompactDisc("Thriller", "Pop", 12.00f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Godfather", "Crime/Drama", 15.00f);
        Book book = new Book("To Kill a Mockingbird", "Fiction", 10.00f);
        
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae){
            System.out.println(m.toString());
        }
    }
}
