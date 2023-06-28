package hust.soict.globalict.test.TestPassingParameter;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        System.out.println("Swap using Wrapper class:");
        DigitalVideoDisc.DVDWrapper wrapJung = new DigitalVideoDisc.DVDWrapper(jungleDVD);
        DigitalVideoDisc.DVDWrapper wrapCinder = new DigitalVideoDisc.DVDWrapper(cinderellaDVD);
        swap(wrapJung, wrapCinder);
        System.out.println("Jungle DVD title: " + wrapJung.dvd.getTitle());
    }

    public static void swap(Object a, Object b) {
        Object temp = a;
        a = b;
        b = temp;
    }

    public static void swap(DigitalVideoDisc.DVDWrapper disc1, DigitalVideoDisc.DVDWrapper disc2) {
        DigitalVideoDisc.DVDWrapper temp = disc1;
        disc1 = disc2;
        disc2 = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTilte = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTilte);
    }
}
