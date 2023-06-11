package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class book extends Media {
    private List<String> authors = new ArrayList<String>();
    private static int nbBooks = 0;

    public book(){
        super();
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public void addAuthor(String authorName){
        List<String> currentAuthor = getAuthors();
        if(currentAuthor.contains(authorName)){
            System.out.println("Author already exists");
            return;
        }
        currentAuthor.add(authorName);
        setAuthors(currentAuthor);
    }
    public void removeAuthor(String authorName){
        List<String> currentAuthor = getAuthors();
        if(!currentAuthor.contains(authorName)){
            System.out.println("Author isn't found");
            return;
        }
        int curIndex = currentAuthor.indexOf(authorName);
        currentAuthor.remove(curIndex);
        setAuthors(currentAuthor);
    }

    public book(String title, String category, float cost, List<String> authors) {
        super(nbBooks++, title, category, cost);
        this.authors = authors;
    }
    @Override
    public String toString(){
        String authors = String.join(", ", this.getAuthors());
        String Desc = String.format(". Book - Title: %s - Category: %s - Authors: %s - Price: %s$", this.getTitle(), this.getCategory(), authors, Float.toString(this.getCost()));
        return Desc;
    }
}
