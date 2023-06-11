package hust.soict.ict.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play(){
        System.out.println("Playing Track:" + this.getTitle());
        System.out.println("Track Length:" + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        Track tempObj = (Track) obj;
        return (this.title.equals(tempObj.getTitle()) && this.length == tempObj.getLength());
    }
}
