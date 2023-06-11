package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemOrdered = new ArrayList<Media>();

    public void addMedia(Media item){
        if(this.itemOrdered.size() == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is Almost Full");
            return;
        }
        this.itemOrdered.add(item);
        System.out.println("The Media item is added to the cart");
        System.out.println("Number of Disc currently in the cart: " + this.itemOrdered.size());
    }
    public void addMedia(Media[] dvdList){
        if(this.itemOrdered.size() + dvdList.length >= MAX_NUMBER_ORDERED){
            System.out.println("The numbers of Disc in the list if added will be larger than the max quantity of discs the cart allow, please remove some items");
        }
        this.itemOrdered.addAll(Arrays.asList(dvdList));
        System.out.println("The Media item(s) are added to the cart");
        System.out.println("Number of Discs currently in the cart: " + this.itemOrdered.size());
    }
    public void addMedia(Media Disc1, Media Disc2){
        if(this.itemOrdered.size() + 2 == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is Almost Full");
            return;
        }
        this.itemOrdered.add(Disc1);
        this.itemOrdered.add(Disc2);
        System.out.println("The items are added to the cart");
        System.out.println("Number of Disc currently in the cart: " + this.itemOrdered.size());
    }
    /*public void addDigitalVideoDisc(hust.soict.ict.aims.media.DigitalVideoDisc... Discs){
        if(this.qtyOrdered + Discs.length > MAX_NUMBER_ORDERED){
            System.out.println("The numbers of Disc in the list if added will be larger than the max quantity of discs the cart allow, please remove some items");
        }
        for(hust.soict.ict.aims.media.DigitalVideoDisc item : Discs){
            this.itemOrdered[this.qtyOrdered] = item;
            this.qtyOrdered++;
        }
        System.out.println("The disc(s) are added to the cart");
        System.out.println("Number of Discs currently in the cart: " + this.qtyOrdered);
    }*/
    public void removeMedia(Media Disc){
        int discID = this.itemOrdered.indexOf(Disc);
        this.itemOrdered.remove(discID);
        System.out.println("Disc deleted");
    }
    public float totalCost(){
        float TotalCost = 0.0f;
        for(Media item : this.itemOrdered){
            TotalCost += item.getCost();
        }
        return TotalCost;
    }
    public void searchByID(int reqID){
        int it = 0;
        for(Media item : this.itemOrdered){
            if(item.getID() == reqID){
                System.out.println(Integer.toString(it) + item.toString());
                it++;
            }
        }
        if(it == 0)
            System.out.println("No DVD with id " + Integer.toString(reqID) + " found.");
    }

    public void searchByTitle(String reqTitle){
        int it = 0;
        for(Media item : this.itemOrdered){
            if(item.isMatch(reqTitle)){
                System.out.println(Integer.toString(it) + item.toString());
                it++;
            }
        }
        if(it == 0)
            System.out.println("No DVD with title " + reqTitle + " found.");
    }
    public void printCart() {
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items");
        int i = 0;
        for (Media item : this.itemOrdered){
            System.out.print(i++);
            System.out.println(item.toString());
        }
        System.out.println("Total cost: " + this.totalCost() + "$");
        System.out.println("************************************************");
    }
}
