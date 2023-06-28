package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private static int nbBooks = 0;
    private List<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(nbBooks++, title, category, cost);
        this.authors = authors;
    }
    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author already exists");
            return;
        }
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author isn't found");
            return;
        }
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        String authors = String.join(", ", this.getAuthors());
        return String.format(". Book - Title: %s - Category: %s - Authors: %s - Price: %s$", this.getTitle(), this.getCategory(), authors, this.getCost());
    }
}
