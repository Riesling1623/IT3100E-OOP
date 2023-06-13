package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;


public class Aims {
    
    private static Store store = new Store();
    private static Cart cart = new Cart();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
            }
        }
    }

    public static void showMenu(){
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(Scanner scanner){
        store.displayStore();
        
        while (true){
            storeMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    viewCurrentCart(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the options.");
                    break;
            }
        }
    }

    public static void storeMenu(){
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails(Scanner scanner){
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null){
            media.toString();
            while (true){
                mediaDetailsMenu();
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1:
                        cart.addMedia(media);
                        System.out.println("The media has been added to the cart.");
                        return;
                    case 2:
                        if (media instanceof Playable){
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        return;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option: Please choose a number from the menu.");
                        break;
                }
            }
        } else {
            System.out.println("No media fouund with the given title.");
        }
    }

    public static void mediaDetailsMenu(){
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart(Scanner scanner){
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null){
            cart.addMedia(media);
            System.out.println("The media has been added to cart.");
        }
        else {
            System.out.println("No media found with the given title");
        }
    }

    public static void playMedia(Scanner scanner){
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null){
            if (media instanceof Playable){
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot play.");
            }
        } else {
            System.out.println("No media found with the given title");
        }
    }

    public static void viewCurrentCart(Scanner scanner){
        cart.print();

        while (true){
            cartMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    filterMediaInCart(scanner);
                    break;
                case 2:
                    sortMediaInCart(scanner);
                    break;
                case 3:
                    removeMediaFromCart(scanner);
                    break;
                case 4:
                    playMediaFromCart(scanner);
                    break;
                case 5:
                    placeOrder();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the option.");
                    break;
            }
        }
    }

    public static void cartMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media in cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediaInCart(Scanner scanner){
        while (true){
            filterMenu();
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    filterMediaById(scanner);
                    return;
                case 2:
                    filterMediaByTitle(scanner);
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the option.");
                    break;
            }
        }
    }

    public static void filterMenu(){
        System.out.println("Filter options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void filterMediaById(Scanner scanner){
        System.out.println("Enter the id of the media: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        cart.filterCartById(id);
    }

    public static void filterMediaByTitle(Scanner scanner){
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        cart.filterCartByTitle(title);
    }

    public static void sortMediaInCart(Scanner scanner){
        while (true){
            sortMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    sortMediaByTitle();
                    return;
                case 2:
                    sortMediaByCost();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the option.");
                    break;
            }
        }
    }

    public static void sortMenu(){
        System.out.println("Sort options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void sortMediaByTitle(){
        cart.sortCartByTitle();
    }

    public static void sortMediaByCost(){
        cart.sortCartByCost();
    }

    public static void removeMediaFromCart(Scanner scanner){
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = cart.searchCart(title);
        if (media != null){
            cart.removeMedia(media);
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("No media found with the given title in the cart");
        }
    }

    public static void playMediaFromCart(Scanner scanner){
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = cart.searchCart(title);
        if (media != null){
            if (media instanceof Playable){
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("No media found with the given title in the cart.");
        }
    }

    public static void placeOrder(){
        cart.placeOrder();
        System.out.println("An order has been created. The current cart has been emptied.");
    }

    public static void updateStore(Scanner scanner){
        while (true){
            updateStoreMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    addMediaToStore(scanner);
                    break;
                case 2:
                    removeMediaFromStore(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the option.");
                    break;
            }
        }
    }

    public static void updateStoreMenu(){
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToStore(Scanner scanner){
        System.out.print("Enter the type of media (1: DVD, 2: CD, 3: Book): ");
        int mediaType = scanner.nextInt();
        scanner.nextLine();

        Media media;

        switch (mediaType){
            case 1:
                media = createDVD(scanner);
                break;
            case 2:
                media = createCD(scanner);
                break;
            case 3:
                media = createBook(scanner);
                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }
        store.addMedia(media);
        System.out.println("Media added to store.");
    }

    public static Media createDVD(Scanner scanner){
        DigitalVideoDisc dvd = new DigitalVideoDisc();
        
        System.out.print("Enter the DVD title: ");
        dvd.setTitle(scanner.nextLine());
        System.out.print("Enter the DVD category: ");
        dvd.setCategory(scanner.nextLine());
        System.out.print("Enter the DVD director: ");
        dvd.setDirector(scanner.nextLine());
        System.out.print("Enter the DVD length: ");
        dvd.setLength(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the DVD cost: ");
        dvd.setCost(scanner.nextFloat());
        scanner.nextLine();

        return dvd;
    }

    public static Media createCD(Scanner scanner){
        CompactDisc cd = new CompactDisc();
        
        System.out.print("Enter the CD title: ");
        cd.setTitle(scanner.nextLine());
        System.out.print("Enter the CD category: ");
        cd.setCategory(scanner.nextLine());
        System.out.print("Enter the CD director: ");
        cd.setDirector(scanner.nextLine());
        System.out.print("Enter the CD length: ");
        cd.setLength(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the CD cost: ");
        cd.setCost(scanner.nextFloat());
        scanner.nextLine();
        System.out.print("Enter the CD artist: ");
        cd.setArtist(scanner.nextLine());

        return cd;
    }

    public static Media createBook(Scanner scanner){
        Book book = new Book();
        
        System.out.print("Enter the book title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter the book category: ");
        book.setCategory(scanner.nextLine());
        System.out.print("Enter the book director: ");
        book.setCost(scanner.nextFloat());
        scanner.nextLine();

        return book;
    }

    public static void removeMediaFromStore(Scanner scanner){
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null){
            store.removeMedia(media);
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("No media found with the given title.");
        }
    }

}
