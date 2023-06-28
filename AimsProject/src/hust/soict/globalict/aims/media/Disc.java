package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private static final int nbDiscs = 0;
    protected int length;
    protected String director;

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title) {
        super(id, title);
        this.length = 0;
        this.director = null;
    }

    public Disc() {
        super();
        this.length = 0;
        this.director = null;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
