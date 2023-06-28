package hust.soict.globalict.test.StoreTest;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store curStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        curStore.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        curStore.addMedia(dvd2);

        curStore.printStore();
        curStore.removeMedia(dvd2);
        curStore.printStore();
    }
}
