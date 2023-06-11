package hust.soict.ict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;
    public void setDirector(String director) {
        super.director = director;
    }

    public void setLength(int length) {
        super.length = length;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDiscs++, title, category, cost, length, director);
    }
    public DigitalVideoDisc(String title){
        super(nbDigitalVideoDiscs++, title);
    }
    public String toString(){
        String Desc = String.format(".DVD - %s - %s - %s - %s: %s$", this.getTitle(), this.getCategory(), this.getDirector(), Integer.toString(this.getLength()), Float.toString(this.getCost()));
        return Desc;
    }
    public boolean isMatch(String reqTitle){
        return reqTitle.equalsIgnoreCase(this.getTitle());
    }
    public static class DVDWrapper {
        public DigitalVideoDisc dvd;
        public DVDWrapper(DigitalVideoDisc dvd){
            this.dvd = dvd;
        }
    }
    @Override
    public void play(){
        System.out.println("Playing DVD:" + this.getTitle());
        System.out.println("DVD Length:" + this.getLength());
    }
}
