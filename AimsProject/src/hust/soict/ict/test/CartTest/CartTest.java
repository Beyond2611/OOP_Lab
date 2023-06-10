package hust.soict.ict.test.CartTest;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.disc.DigitalVideoDisc;
import hust.soict.ict.aims.media.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Cart cart = new Cart();
        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc (dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc (dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc ("Aladin",
                "Animation", 18.99f);
        cart.addDigitalVideoDisc (dvd3);
        List<String> authorList = new ArrayList<String>();
        authorList.add("Mike");
        authorList.add("Mike2");
        book book1 = new book(1, "Book1", "Science", 20.99f, authorList);
        //System.out.println(book1.getAuthors());
        book1.addAuthor("Big Mike");
        //System.out.println(book1.getAuthors());
        book1.removeAuthor("Mike");
        //System.out.println(book1.getAuthors());
        boolean isExit = false;
        while(isExit == false) {
            cart.printCart();
            System.out.println("Search by:");
            System.out.println("1. ID:");
            System.out.println("2. Title:");
            int opt = in.nextInt();
            in.nextLine();
            if(opt == 1) {
                System.out.println("Input DVD ID:");
                int dvdID = in.nextInt();
                cart.searchByID(dvdID);
            }
            else{
                System.out.println("Input DVD Title:");
                String dvdTitle = in.nextLine();
                cart.searchByTitle(dvdTitle);
            }
            isExit = true;
        }
    }
}
