package hust.soict.ict.aims.aims;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.*;
import hust.soict.ict.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    public static final Scanner in = new Scanner(System.in);
    public static void mimicClear(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }
    static Store curStore = new Store();
    static Cart curCart = new Cart();
    public static void showMenu() {

        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int opt = in.nextInt();
        in.nextLine();
        switch (opt){
            case 0:{
                System.exit(0);
            }
            case 1:{
                mimicClear();
                storeMenu();
                break;
            }
            case 2: {
                curStore.printStore();
                System.out.println("--------------------------------");
                System.out.println("1. Add media");
                if(!curStore.getItemsInStore().isEmpty())
                System.out.println("2. Remove media");
                System.out.println("0. Back to Menu");
                System.out.println("--------------------------------");
                int opt2 = in.nextInt();
                in.nextLine();
                switch (opt2){
                    case 0:{
                        showMenu();
                        break;
                    }
                    case 1:{
                        mimicClear();
                        System.out.println("--------------------------------");
                        System.out.println("1. CD");
                        System.out.println("2. DVD");
                        System.out.println("3. Book");
                        System.out.println("0. Back to Menu");
                        System.out.println("--------------------------------");
                        int opt3 = in.nextInt();
                        in.nextLine();
                        switch(opt3){
                            case 0:{
                                break;
                            }
                            case 1:{
                                System.out.print("Enter title : ");
                                String title = in.nextLine();
                                System.out.print("Enter category : ");
                                String category = in.nextLine();
                                System.out.print("Enter cost : ");
                                float cost = in.nextFloat();
                                in.nextLine();
                                System.out.print("Enter director : ");
                                String director = in.nextLine();
                                System.out.print("Enter length : ");
                                int length = in.nextInt();
                                in.nextLine();
                                System.out.print("Enter artist : ");
                                String artist = in.nextLine();
                                System.out.print("Number of tracks: ");
                                int numTrack = in.nextInt();
                                in.nextLine();
                                List<Track> tracks = new ArrayList<>();
                                for(int i = 1; i <= numTrack; ++i){
                                    System.out.println("Track " + Integer.toString(i) + " title:");
                                    String tempTitle = in.nextLine();
                                    System.out.println("Track " + Integer.toString(i) + " length:");
                                    int tempLength = in.nextInt();
                                    in.nextLine();
                                    Track tempTrack = new Track(tempTitle, tempLength);
                                    tracks.add(tempTrack);
                                }
                                CompactDisc CD = new CompactDisc(title , category , cost , length , director , artist, tracks );
                                curStore.addMedia(CD);
                                System.out.println("Media added!");
                                break;
                            }
                            case 2:{
                                System.out.print("Enter title : ");
                                String title = in.nextLine();
                                System.out.print("Enter category : ");
                                String category = in.nextLine();
                                System.out.print("Enter cost : ");
                                float cost = in.nextFloat();
                                in.nextLine();
                                System.out.print("Enter director : ");
                                String director = in.nextLine();
                                System.out.print("Enter length : ");
                                int length = in.nextInt();

                                DigitalVideoDisc DVD = new DigitalVideoDisc(title , category , director ,length , cost);
                                curStore.addMedia(DVD);
                                System.out.println("Media added!");
                                break;
                            }
                            case 3:{
                                System.out.print("Enter title : ");
                                String title = in.nextLine();
                                System.out.print("Enter category : ");
                                String category = in.nextLine();
                                System.out.print("Enter cost : ");
                                float cost = in.nextFloat();
                                in.nextLine();
                                System.out.print("Number of Authors: ");
                                int numAuthor = in.nextInt();
                                in.nextLine();
                                List<String> authors = new ArrayList<>();
                                for(int i = 1; i <= numAuthor; ++i){
                                    System.out.println("Author " + Integer.toString(i) + "'s name:");
                                    String tempTitle = in.nextLine();
                                    authors.add(tempTitle);
                                }
                                book curbook = new book(title , category , cost, authors);
                                curStore.addMedia(curbook);
                                System.out.println("Media added!");
                                break;
                            }
                        }
                        System.out.println("Press Enter key to continue...");
                        try
                        {
                            System.in.read();
                            in.nextLine();
                            mimicClear();
                            showMenu();
                        }
                        catch(Exception e)
                        {}

                        break;
                    }
                    case 2:{
                        System.out.println("Choose media id for removal:");
                        int id = in.nextInt();
                        in.nextLine();
                        System.out.println(id);
                        while(!curStore.removeMedia(id)){
                            System.out.println("Choose again:");
                            id = in.nextInt();
                            in.nextLine();
                        }
                        System.out.println("Media removed!");
                        System.out.println("Press Enter key to continue...");
                        try
                        {
                            System.in.read();
                            in.nextLine();
                            mimicClear();
                            showMenu();
                        }
                        catch(Exception e)
                        {}
                        //showMenu();
                        break;
                    }
                }
                break;
            }
            case 3:{
                mimicClear();
                cartMenu();
                break;
            }
        }
    }
    public static void storeMenu() {
        curStore.printStore();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int opt = in.nextInt();
        in.nextLine();
        switch(opt){
            case 0:{
                showMenu();
                break;
            }
            case 1:{
                System.out.println("Input media title:");
                String title = in.nextLine();
                boolean ok = false;
                while(!ok){
                    if(title.equals("")){
                        System.out.println("Title can't be empty! Please reinput:");
                        title = in.nextLine();
                        continue;
                    }
                    ok = true;
                }
                mimicClear();
                Media curMedia = curStore.searchByTitle(title);
                if(curMedia.getID() != - 1) {
                    mediaDetailsMenu(curMedia);
                }
                else{
                    System.out.println("Press Enter key to continue...");
                    try
                    {
                        System.in.read();
                        in.nextLine();
                        mimicClear();
                        storeMenu();
                    }
                    catch(Exception e)
                    {}
                }
                break;
            }
            case 2:{
                mimicClear();
                curStore.printStore();
                System.out.println("--------------------------------");
                System.out.println("Choose the media you want to add to cart (choose -1 to go back):");
                String choice = in.nextLine();
                int ok = 0;
                while(ok == 0){
                    if(choice.equals("-1")){
                        mimicClear();
                        storeMenu();
                        break;
                    }
                    if(choice == ""){
                        System.out.println("Can't be empty, please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    if(curStore.searchByTitle(choice).getID() == -1){
                        System.out.println("Please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    ok = 1;
                }
                Media curMedia = curStore.searchByTitle(choice);
                curCart.addMedia(curMedia);
                System.out.println("Press Enter key to continue...");
                try
                {
                    System.in.read();
                    in.nextLine();
                    mimicClear();
                    storeMenu();
                }
                catch(Exception e)
                {}
                break;
            }
            case 3:{
                mimicClear();
                curStore.printStore();
                System.out.println("--------------------------------");
                System.out.println("Choose the media you want to play (choose -1 to go back):");
                String choice = in.nextLine();
                int ok = 0;
                while(ok == 0){
                    if(choice.equals("-1")){
                        mimicClear();
                        storeMenu();
                        break;
                    }
                    if(choice == ""){
                        System.out.println("Can't be empty, please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    if(curStore.searchByTitle(choice).getID() == -1){
                        System.out.println("Please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    if(curStore.searchByTitle(choice) instanceof book){
                        System.out.println("Can't play a book, please re-enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    ok = 1;
                }
                Media curMedia = curStore.searchByTitle(choice);
                if(curMedia instanceof DigitalVideoDisc)
                    ((DigitalVideoDisc) curMedia).play();
                if(curMedia instanceof CompactDisc)
                    ((CompactDisc) curMedia).play();
                System.out.println("Press Enter key to go back...");
                try
                {
                    System.in.read();
                    in.nextLine();
                    mimicClear();
                    storeMenu();
                }
                catch(Exception e)
                {}
                break;
            }
            case 4:{
                mimicClear();
                cartMenu();
                break;
            }
        }
    }
    public static void mediaDetailsMenu(Media curMedia) {
        System.out.println(curMedia.toString());
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if(!(curMedia instanceof book))
            System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int opt = in.nextInt();
        in.nextLine();
        switch (opt){
            case 0: {
                storeMenu();
                break;
            }
            case 1:{
                curCart.addMedia(curMedia);
                System.out.println("Press Enter key to continue...");
                try
                {
                    System.in.read();
                    in.nextLine();
                    mimicClear();
                    storeMenu();
                }
                catch(Exception e)
                {}
                break;
            }
            case 2:{
                if(curMedia instanceof DigitalVideoDisc)
                    ((DigitalVideoDisc) curMedia).play();
                if(curMedia instanceof CompactDisc)
                    ((CompactDisc) curMedia).play();
                System.out.println("Press Enter key to go back...");
                try
                {
                    System.in.read();
                    in.nextLine();
                    mimicClear();
                    mediaDetailsMenu(curMedia);
                }
                catch(Exception e)
                {}
                break;
            }
        }
    }
    public static void cartMenu(){
        curCart.printCart();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        int opt = in.nextInt();
        in.nextLine();
        switch (opt){
            case 0:{
                mimicClear();
                storeMenu();
                break;
            }
            case 1:{
                mimicClear();
                System.out.println("--------------------------------");
                System.out.println("Filter by:");
                System.out.println("1. ID");
                System.out.println("2. Title");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                int opt2 = in.nextInt();
                in.nextLine();
                switch (opt2){
                    case 0:{
                        mimicClear();
                        cartMenu();
                        break;
                    }
                    case 1:{
                        System.out.println("Input media id:");
                        int mediaID = in.nextInt();
                        in.nextLine();
                        Media curMedia = curCart.searchByID(mediaID);
                        while(curMedia.getID() == -1){
                            System.out.println("Please re input:");
                            mediaID = in.nextInt();
                            in.nextLine();
                            curMedia = curCart.searchByID(mediaID);
                        }
                        System.out.println("**********************CART**********************");
                        System.out.println("Ordered Items");
                        System.out.println(curMedia.toString());
                        System.out.println("Total cost: " + Float.toString(curMedia.getCost()) + "$");
                        System.out.println("************************************************");
                        System.out.println("Press Enter key to go back...");
                        try
                        {
                            System.in.read();
                            in.nextLine();
                            mimicClear();
                            cartMenu();
                        }
                        catch(Exception e)
                        {}
                        break;
                    }
                    case 2:{
                        System.out.println("Input media title:");
                        String mediaTitle = in.nextLine();
                        Media curMedia = curCart.searchByTitle(mediaTitle);
                        while(curMedia.getID() == -1){
                            System.out.println("Please re input:");
                            mediaTitle = in.nextLine();
                            curMedia = curCart.searchByTitle(mediaTitle);
                        }
                        System.out.println("**********************CART**********************");
                        System.out.println("Ordered Items");
                        System.out.println(curMedia.toString());
                        System.out.println("Total cost: " + Float.toString(curMedia.getCost()) + "$");
                        System.out.println("************************************************");
                        System.out.println("Press Enter key to go back...");
                        try
                        {
                            System.in.read();
                            in.nextLine();
                            mimicClear();
                            cartMenu();
                        }
                        catch(Exception e)
                        {}
                        break;
                    }
                }
                break;
            }
            case 2:{
                mimicClear();
                System.out.println("--------------------------------");
                System.out.println("Sort by:");
                System.out.println("1. Title");
                System.out.println("2. Cost");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                int opt2 = in.nextInt();
                in.nextLine();
                switch (opt2){
                    case 0:{
                        mimicClear();
                        cartMenu();
                        break;
                    }
                    case 1:{
                        curCart.sortByTitle();
                        System.out.println("Cart sorted!");
                        curCart.printCart();
                        System.out.println("Press Enter key to go back...");
                        try
                        {
                            System.in.read();
                            in.nextLine();
                            mimicClear();
                            cartMenu();
                        }
                        catch(Exception e)
                        {}
                        break;
                    }
                    case 2:{
                        curCart.sortByCost();
                        System.out.println("Cart sorted!");
                        curCart.printCart();
                        System.out.println("Press Enter key to go back...");
                        try
                        {
                            System.in.read();
                            in.nextLine();
                            mimicClear();
                            cartMenu();
                        }
                        catch(Exception e)
                        {}
                        break;
                    }
                }
            }
            case 3:{
                mimicClear();
                curCart.printCart();
                System.out.println("--------------------------------");
                System.out.println("Choose the media you want to remove from cart (choose -1 to go back):");
                String choice = in.nextLine();
                int ok = 0;
                while(ok == 0){
                    if(choice.equals("-1")){
                        mimicClear();
                        cartMenu();
                        break;
                    }
                    if(choice == ""){
                        System.out.println("Can't be empty, please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    if(curCart.searchByTitle(choice).getID() == -1){
                        System.out.println("Please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    ok = 1;
                }
                Media curMedia = curCart.searchByTitle(choice);
                curCart.removeMedia(curMedia);
                System.out.println("Press Enter key to continue...");
                try
                {
                    System.in.read();
                    in.nextLine();
                    mimicClear();
                    cartMenu();
                }
                catch(Exception e)
                {}
                break;
            }
            case 4:{
                mimicClear();
                curCart.printCart();
                System.out.println("--------------------------------");
                System.out.println("Choose the media you want to play (choose -1 to go back):");
                String choice = in.nextLine();
                int ok = 0;
                while(ok == 0){
                    if(choice.equals("-1")){
                        mimicClear();
                        cartMenu();
                        break;
                    }
                    if(choice == ""){
                        System.out.println("Can't be empty, please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    if(curCart.searchByTitle(choice).getID() == -1){
                        System.out.println("Please re enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    if(curCart.searchByTitle(choice) instanceof book){
                        System.out.println("Can't play a book, please re-enter:");
                        choice = in.nextLine();
                        continue;
                    }
                    ok = 1;
                }
                Media curMedia = curCart.searchByTitle(choice);
                if(curMedia instanceof DigitalVideoDisc)
                    ((DigitalVideoDisc) curMedia).play();
                if(curMedia instanceof CompactDisc)
                    ((CompactDisc) curMedia).play();
                System.out.println("Press Enter key to go back...");
                try
                {
                    System.in.read();
                    in.nextLine();
                    mimicClear();
                    cartMenu();
                }
                catch(Exception e)
                {}
                break;
            }
            case 5:{
                curCart.clearCart();
                System.out.println("Order placed!");
                System.out.println("Press Enter key to go back...");
                try
                {
                    System.in.read();
                    in.nextLine();
                    mimicClear();
                    cartMenu();
                }
                catch(Exception e)
                {}
                break;
            }
        }
    }
    public static void main (String[] args){
        List<Media> mediae = new ArrayList<>();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        mediae.add(dvd1);
        mediae.add(dvd2);
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track("Track1", 20);
        tracks.add(track1);
        Track track2 = new Track("Track2", 20);
        tracks.add(track2);
        Track track3 = new Track("Track3", 20);
        tracks.add(track3);
        Track track4 = new Track("Track4", 20);
        tracks.add(track4);
        Track track5 = new Track("Track5", 20);
        CompactDisc disc1 = new CompactDisc("Disc1", "Pop", 20.99f, 100, "michael bay", "Tenkitsune" , tracks);
        mediae.add(disc1);
        List<String> authorList = new ArrayList<>();
        authorList.add("Mike");
        authorList.add("Mike2");
        book book1 = new book("Book1", "Science", 20.99f, authorList);
        mediae.add(book1);
        for(Media item : mediae)
            curStore.addMedia(item);
        showMenu();
    }
}
