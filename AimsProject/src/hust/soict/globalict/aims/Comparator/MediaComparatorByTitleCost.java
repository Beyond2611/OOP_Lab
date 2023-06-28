package hust.soict.globalict.aims.Comparator;

import hust.soict.globalict.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media item1, Media item2) {
        int costCompare = Float.compare(item1.getCost(), item2.getCost());
        int titleCompare = item1.getTitle().compareTo(item2.getTitle());
        return titleCompare == 0 ? costCompare : titleCompare;
    }
}
