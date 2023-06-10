package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class book extends Media {
    private List<String> authors = new ArrayList<String>();
    private static int nbBooks = 0;

    public book(){}

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
        this.id = nbBooks++;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
    }
}
