package hust.soict.globalict.test.CartTest;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cart cart = new Cart();
        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        try {
            cart.addMedia(dvd1);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        try {
            cart.addMedia(dvd2);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }
        try {
            cart.addMedia(dvd2);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(dvd2.equals("what"));
        List<String> authorList = new ArrayList<String>();
        authorList.add("Mike");
        authorList.add("Mike2");
        Book book1 = new Book("Book1", "Science", 20.99f, authorList);
        //System.out.println(book1.getAuthors());
        book1.addAuthor("Big Mike");
        //System.out.println(book1.getAuthors());
        book1.removeAuthor("Mike");
        //System.out.println(book1.getAuthors());
        boolean isExit = false;
        while (!isExit) {
            cart.printCart();
            System.out.println("Search by:");
            System.out.println("1. ID:");
            System.out.println("2. Title:");
            int opt = in.nextInt();
            in.nextLine();
            if (opt == 1) {
                System.out.println("Input DVD ID:");
                int dvdID = in.nextInt();
                cart.searchByID(dvdID);
            } else {
                System.out.println("Input DVD Title:");
                String dvdTitle = in.nextLine();
                Media curMedia = cart.searchByTitle(dvdTitle);
                if (curMedia.getID() != -1) {
                    System.out.println(curMedia);
                }
            }
            isExit = true;
        }
    }
}
