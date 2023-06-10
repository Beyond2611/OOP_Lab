package hust.soict.ict.aims.media;

public class DigitalVideoDisc extends Media{
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs++;
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
}
