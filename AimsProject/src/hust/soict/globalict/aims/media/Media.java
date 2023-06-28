package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.Comparator.MediaComparatorByCostTitle;
import hust.soict.globalict.aims.Comparator.MediaComparatorByTitleCost;

import java.util.Comparator;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
        this.category = null;
        this.cost = 0.00f;
    }

    public Media() {
        this.id = -1;
        this.title = null;
        this.category = null;
        this.cost = 0.00f;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
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

    public boolean isMatch(String reqTitle) {
        return reqTitle.equalsIgnoreCase(this.getTitle());
    }

    public boolean filterProperty(String filter, String filterType) {
        if (filter == null || filter.isEmpty()) return true;

        if (filterType.equals("title"))
            return this.getTitle().toLowerCase().contains(filter.toLowerCase());


        if (filterType.equals("id"))
            return Integer.toString(this.getID()).toLowerCase().contains(filter.toLowerCase());


        return false;
    }
    @Override
    public boolean equals(Object obj) {
        Media tempObj = (Media) obj;
        return this.title.equals(tempObj.title);
    }
}
