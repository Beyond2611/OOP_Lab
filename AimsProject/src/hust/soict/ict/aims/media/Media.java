package hust.soict.ict.aims.media;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

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

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(int id, String title){
        this.id = id;
        this.title = title;
        this.category = null;
        this.cost = 0.00f;
    }
    public Media(){
    }

    public boolean isMatch(String reqTitle){
        return reqTitle.equalsIgnoreCase(this.getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        Media tempObj = (Media) obj;
        return this.title.equals(tempObj.title);
    }
}
