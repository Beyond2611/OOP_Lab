package hust.soict.ict.aims.aims;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main (String[] args){
        //Create a new cart
        Cart anOrder = new Cart();
        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc (dvd1);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                    "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc (dvd2);
        DigitalVideoDisc[] List = {new DigitalVideoDisc("Anything", "Comedy", "Ceres Fauna", 90, 200f), new DigitalVideoDisc("Anything2", "Comedy", "Ceres Fauna", 90, 200f)};
        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println("Disc 1 id is " + Integer.toString(dvd1.getID()));
        anOrder.addDigitalVideoDisc(List);
        System.out.println(anOrder.totalCost());
        //Remove and re calculate the total
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println(anOrder.totalCost());
        anOrder.addDigitalVideoDisc(dvd2, dvd1);
        System.out.println(anOrder.totalCost());

    }
}
