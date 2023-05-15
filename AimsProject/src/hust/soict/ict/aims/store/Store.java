package hust.soict.ict.aims.store;

import hust.soict.ict.aims.disc.DigitalVideoDisc;

import java.util.Arrays;

public class Store {
    private static DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[1001];
    public static int numDiscs = 0;
    public void addDisc(DigitalVideoDisc dvd) {
        itemsInStore[numDiscs++] = dvd;
    }

    public void removeDisc(DigitalVideoDisc dvd) {
        int it, j;
        for(it = 0, j = 0; j < numDiscs; ++j)
        {
            if(!(itemsInStore[j] == dvd)){
                itemsInStore[it] = itemsInStore[j];
                it++;
            }
        }
        itemsInStore = Arrays.copyOf(itemsInStore, it);
        System.out.println("Disc deleted");
        numDiscs--;
    }

    public void printStore() {
        if (numDiscs == 0){
            System.out.println("There isn't any items in the store");
        }
        for (int i = 0; i < numDiscs; ++ i)
            System.out.println(itemsInStore[i].toString());
    }
}
