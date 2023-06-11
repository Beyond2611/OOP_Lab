package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track>  tracks = new ArrayList<>();
    private static int nbCompDiscs = 0;

    public CompactDisc(String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
        super(nbCompDiscs++, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String artist, List<Track> tracks) {
        super(nbCompDiscs++, title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track demoTrack){
        List<Track>  curTracks = this.tracks;
        if(curTracks.contains(demoTrack))
        {
            System.out.println("Track already exists");
            return;
        }
        this.tracks.add(demoTrack);
    }
    public void removeTrack(Track demoTrack){
        List<Track>  curTracks = this.tracks;
        if(!curTracks.contains(demoTrack))
        {
            System.out.println("Track isn't found");
            return;
        }
        int trackID = curTracks.indexOf(demoTrack);
        this.tracks.remove(trackID);
    }
    public int getLength(){
        int curLength = 0;
        for(Track temp : this.tracks){
            curLength += temp.getLength();
        }
        return curLength;
    }

    @Override
    public void play() {
        for(Track trackIT : this.tracks){
            trackIT.play();
        }
    }
    @Override
    public String toString(){
        String Desc = String.format(".DVD - %s - %s - %s - %s: %s$", this.getTitle(), this.getCategory(), this.getDirector(), Integer.toString(this.getLength()), Float.toString(this.getCost()));
        return Desc;
    }
}
