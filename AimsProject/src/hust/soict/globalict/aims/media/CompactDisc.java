package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private static int nbCompDiscs = 0;
    private final String artist;
    private List<Track> tracks;

    public CompactDisc(String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
        super(nbCompDiscs++, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category,float cost, String director, int length, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String artist, List<Track> tracks) {
        super(nbCompDiscs++, title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track demoTrack) {
        if (this.tracks.contains(demoTrack)) {
            System.out.println("Track already exists");
            return;
        }
        this.tracks.add(demoTrack);
    }

    public void removeTrack(Track demoTrack) {
        if (!this.tracks.contains(demoTrack)) {
            System.out.println("Track isn't found");
            return;
        }
        this.tracks.remove(demoTrack);
    }

    public int getLength() {
        return this.tracks.stream().mapToInt(Track::getLength).sum();
    }

    @Override
    public void play() {
        this.tracks.forEach(Track::play);
    }

    @Override
    public StringBuffer playString() throws PlayerException {
        if(this.tracks.isEmpty())
            throw new PlayerException("ERROR: CD has no track");
        StringBuffer info = new StringBuffer();
        info.append("Playing CD: ").append(this.getTitle()).append("\n").append("CD length: ").append(this.getLength()).append("\n");

        for (Track t : tracks) {
            StringBuffer trackInfo = t.playString();
            info.append(trackInfo).append("\n");
        }
        return info;
    }

    @Override
    public String toString() {
        StringBuilder tracksList = new StringBuilder();
        for (Track item : this.tracks)
            tracksList.append(item.getTitle()).append(" , ");

        return String.format(". CD - Title: %s - Category: %s - Artist: %s - Tracks: %s - Price : %s$", this.getTitle(), this.getCategory(), this.getArtist(), tracksList, this.getCost());
    }
}
