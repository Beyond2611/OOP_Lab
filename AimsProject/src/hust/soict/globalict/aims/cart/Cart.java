package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.media.Disc;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media item) throws LimitExceededException {
        if (this.itemsOrdered.size() == MAX_NUMBER_ORDERED) {
            throw new LimitExceededException("ERROR: The cart is almost full");
        }
        if (this.itemsOrdered.contains(item)) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Media already existed in cart");
            alert.showAndWait();
            return;
        }
        this.itemsOrdered.add(item);
        System.out.println("The Media item is added to the cart");
        System.out.println("Number of Media currently in the cart: " + this.itemsOrdered.size());
    }

    public void addMedia(Media[] dvdList) {
        if (this.itemsOrdered.size() + dvdList.length >= MAX_NUMBER_ORDERED) {
            System.out.println("The numbers of Disc in the list if added will be larger than the max quantity of discs the cart allow, please remove some items");
        }
        for (Media item : dvdList) {
            if (this.itemsOrdered.contains(item)) {
                System.out.println("Item is already in the cart!");
                return;
            }
        }
        this.itemsOrdered.addAll(Arrays.asList(dvdList));
        System.out.println("The Media item(s) are added to the cart");
        System.out.println("Number of Media currently in the cart: " + this.itemsOrdered.size());
    }

    public void addMedia(Media disc1, Media disc2) {
        if (this.itemsOrdered.size() + 2 == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is Almost Full");
            return;
        }
        if (this.itemsOrdered.contains(disc1) || this.itemsOrdered.contains(disc2)) {
            System.out.println("Item is already in the cart!");
            return;
        }
        this.itemsOrdered.add(disc1);
        this.itemsOrdered.add(disc2);
        System.out.println("The items are added to the cart");
        System.out.println("Number of Media currently in the cart: " + this.itemsOrdered.size());
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
    public void removeMedia(Media Disc) {
        if (!this.itemsOrdered.contains(Disc)) {
            System.out.println("This item isn't found!");
            return;
        }
        this.itemsOrdered.remove(Disc);
        System.out.println("Disc deleted");
    }

    public float totalCost() {
        float cost = 0.0f;
        for (Media item : this.itemsOrdered) {
            cost += item.getCost();
        }
        return cost;
    }

    public Media searchByID(int itemID) {
        if (itemID > this.itemsOrdered.size()) {
            System.out.println("Invalid ID");
            return new Disc();
        }
        return this.itemsOrdered.get(itemID);
    }

    public Media searchByTitle(String reqTitle) {
        Optional<Media> media = itemsOrdered.stream().filter(x -> x.isMatch(reqTitle)).findFirst();
        if (media.isPresent())
            return media.get();

        System.out.println("No Media with title " + reqTitle + " found.");
        return new Disc();
    }

    public void printCart() {
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items");
        int i = 0;
        for (Media item : this.itemsOrdered) {
            System.out.print(i++);
            System.out.println(item.toString());
        }
        System.out.println("Total cost: " + this.totalCost() + "$");
        System.out.println("************************************************");
    }

    public void clearCart() {
        this.itemsOrdered.clear();
    }

    public void sortByTitle() {
        this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
}
