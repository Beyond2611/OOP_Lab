package hust.soict.ict.test.StoreTest;

import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store curStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        curStore.addDisc (dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        curStore.addDisc (dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        curStore.addDisc (dvd3);

        curStore.printStore();
        curStore.removeDisc(dvd2);
        curStore.printStore();
    }
}
