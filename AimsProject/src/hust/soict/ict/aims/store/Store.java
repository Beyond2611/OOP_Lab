package hust.soict.ict.aims.store;

import hust.soict.ict.aims.media.Disc;
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

    public boolean removeMedia(Media item) {
        if(!itemsInStore.contains(item)){
            System.out.println("This item isnt found!");
            return false;
        }
        int itemID = itemsInStore.indexOf(item);
        itemsInStore.remove(itemID);
        System.out.println("Disc deleted");
        return true;
    }
    public boolean removeMedia(int id){
        if(id >= itemsInStore.size()){
            System.out.println("Invalid ID");
            return false;
        }
        itemsInStore.remove(id);
        System.out.println("Media deleted");
        return true;
    }

    public void printStore() {
        if (itemsInStore.isEmpty()){
            System.out.println("There isn't any items in the store");
        }
        int id = 0;
        for (Media item : itemsInStore)
            System.out.println(Integer.toString(id++) + item.toString());
    }
    public Media searchByTitle(String reqTitle){
        int it = 0, ok = 0;
        for(Media item : itemsInStore){
            if(item.isMatch(reqTitle)){
                return item;
            }
            it++;
        }
        System.out.println("No Media with title " + reqTitle + " found.");
        Media noMedia = new Disc();
        return noMedia;
    }
    public static ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
