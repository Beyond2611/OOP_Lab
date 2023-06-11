package hust.soict.ict.aims.store;

import hust.soict.ict.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;

public class Store {
    private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media item) {
        if(itemsInStore.contains(item))
        {
            System.out.println("Item is already in store!");
            return;
        }
        itemsInStore.add(item);
    }

    public void removeMedia(Media item) {
        if(!itemsInStore.contains(item)){
            System.out.println("This item isnt found!");
            return;
        }
        int itemID = itemsInStore.indexOf(item);
        itemsInStore.remove(itemID);
        System.out.println("Disc deleted");
    }

    public void printStore() {
        if (itemsInStore.isEmpty()){
            System.out.println("There isn't any items in the store");
        }
        for (Media item : itemsInStore)
            System.out.println(item.toString());
    }
}
