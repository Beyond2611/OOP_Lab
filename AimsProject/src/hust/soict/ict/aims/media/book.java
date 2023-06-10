package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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

    public book(int id, String title, String category, float cost, List<String> authors) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
    }
}
