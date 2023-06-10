package hust.soict.ict.aims.media;

public class Disc extends Media{
    protected int length;
    protected String director;

    private static int nbDiscs = 0;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(int id,String title, String category, float cost, int length, String director){
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    public Disc(int id,String title){
        super(id, title);
        this.length = 0;
        this.director = null;
    }
}
