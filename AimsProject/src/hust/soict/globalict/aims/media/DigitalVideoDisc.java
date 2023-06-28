package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDiscs++, title, category, cost, length, director);
    }
    public DigitalVideoDisc(int id, String title, String category,float cost, String director, int length) {
        super(id, title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title) {
        super(nbDigitalVideoDiscs++, title);
    }

    public void setDirector(String director) {
        super.director = director;
    }

    public void setLength(int length) {
        super.length = length;
    }

    @Override
    public String toString() {
        return String.format(". DVD - Title: %s - Category: %s - Director: %s - Length: %s - Price: %s$", this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
    }

    @Override
    public void play() {
        System.out.println("Playing DVD:" + this.getTitle());
        System.out.println("DVD Length:" + this.getLength());
    }
    @Override
    public StringBuffer playString() throws PlayerException {
        if (this.getLength() <= 0)
            throw new PlayerException("ERROR: DVD length is non-positive!");

        StringBuffer trackInfo = new StringBuffer();
        trackInfo.append("Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength());
        return trackInfo;
    }

    public static class DVDWrapper {
        public DigitalVideoDisc dvd;

        public DVDWrapper(DigitalVideoDisc dvd) {
            this.dvd = dvd;
        }
    }
}
