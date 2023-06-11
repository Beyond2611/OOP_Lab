package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.Disc;
import hust.soict.ict.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private final ArrayList<Media> itemOrdered = new ArrayList<Media>();

    public void addMedia(Media item){
        if(this.itemOrdered.size() == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is Almost Full");
            return;
        }
        if(this.itemOrdered.contains(item))
        {
            System.out.println("Item is already in the cart!");
            return;
        }
        this.itemOrdered.add(item);
        System.out.println("The Media item is added to the cart");
        System.out.println("Number of Media currently in the cart: " + this.itemOrdered.size());
    }
    public void addMedia(Media[] dvdList){
        if(this.itemOrdered.size() + dvdList.length >= MAX_NUMBER_ORDERED){
            System.out.println("The numbers of Disc in the list if added will be larger than the max quantity of discs the cart allow, please remove some items");
        }
        for(Media item : dvdList){
            if(this.itemOrdered.contains(item))
            {
                System.out.println("Item is already in the cart!");
                return;
            }
        }
        this.itemOrdered.addAll(Arrays.asList(dvdList));
        System.out.println("The Media item(s) are added to the cart");
        System.out.println("Number of Media currently in the cart: " + this.itemOrdered.size());
    }
    public void addMedia(Media Disc1, Media Disc2){
        if(this.itemOrdered.size() + 2 == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is Almost Full");
            return;
        }
        if(this.itemOrdered.contains(Disc1) || this.itemOrdered.contains(Disc2))
        {
            System.out.println("Item is already in the cart!");
            return;
        }
        this.itemOrdered.add(Disc1);
        this.itemOrdered.add(Disc2);
        System.out.println("The items are added to the cart");
        System.out.println("Number of Media currently in the cart: " + this.itemOrdered.size());
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
        if(!this.itemOrdered.contains(Disc)){
            System.out.println("This item isnt found!");
            return;
        }
        this.itemOrdered.remove(Disc);
        System.out.println("Disc deleted");
    }
    public float totalCost(){
        float TotalCost = 0.0f;
        for(Media item : this.itemOrdered){
            TotalCost += item.getCost();
        }
        return TotalCost;
    }
    public Media searchByID(int itemID){
        if(itemID > this.itemOrdered.size()) {
            System.out.println("Invalid ID");
            Media noMedia = new Disc();
            return noMedia;
        }
        return this.itemOrdered.get(itemID);
    }

    public Media searchByTitle(String reqTitle){
        int it = 0;
        for(Media item : this.itemOrdered){
            if(item.isMatch(reqTitle)){
                return item;
            }
            it++;
        }
        System.out.println("No Media with title " + reqTitle + " found.");
        Media noMedia = new Disc();
        return noMedia;
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
    public void clearCart(){
        this.itemOrdered.clear();
    }
    public void sortByTitle(){
        Collections.sort(this.itemOrdered , Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCost(){
        Collections.sort(this.itemOrdered , Media.COMPARE_BY_COST_TITLE);
    }
}
