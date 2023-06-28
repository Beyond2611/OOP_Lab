package hust.soict.globalict.test.TrackTest;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackTest {
    public static void main(String[] args) {
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track("Track1", 20);
        tracks.add(track1);
        Track track2 = new Track("Track2", 20);
        tracks.add(track2);
        Track track3 = new Track("Track3", 20);
        tracks.add(track3);
        Track track4 = new Track("Track4", 20);
        tracks.add(track4);
        Track track5 = new Track("Track5", 20);
        CompactDisc disc1 = new CompactDisc("Disc1", "musiz", tracks);
        System.out.println(disc1.getLength());
        disc1.addTrack(track5);
        System.out.println(disc1.getLength());
        disc1.removeTrack(track2);
        System.out.println(disc1.getLength());
    }
}
