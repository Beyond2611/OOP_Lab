package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track:" + this.getTitle());
        System.out.println("Track Length:" + this.getLength());
    }

    public StringBuffer playString() throws PlayerException {
        if (this.getLength() <= 0)
            throw new PlayerException("ERROR: Track length is non-positive!");

        StringBuffer trackInfo = new StringBuffer();
        trackInfo.append("Playing track: ").append(this.getTitle()).append("\n").append("Track length: ").append(this.getLength());
        return trackInfo;
    }

    @Override
    public boolean equals(Object obj) {
        Track tempObj = (Track) obj;
        return (this.title.equals(tempObj.getTitle()) && this.length == tempObj.getLength());
    }
}
