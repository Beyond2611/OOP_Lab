package hust.soict.ict.test.PolyTest;
import hust.soict.ict.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class PolyTest {

    public static void main(String[] args){
        List<Media> mediae = new ArrayList<>();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        mediae.add(dvd1);
        mediae.add(dvd2);
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
        CompactDisc disc1 = new CompactDisc("Disc1", "Pop", 20.99f, 100, "michael bay", "Tenkitsune" , tracks);
        mediae.add(disc1);
        List<String> authorList = new ArrayList<>();
        authorList.add("Mike");
        authorList.add("Mike2");
        book book1 = new book("Book1", "Science", 20.99f, authorList);
        mediae.add(book1);
        for(Media item : mediae){
            System.out.println(item.toString());
        }
    }
}
