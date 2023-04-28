import java.util.Arrays;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    public int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc Disc){
        if(this.qtyOrdered == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is Almost Full");
            return;
        }
        this.itemOrdered[this.qtyOrdered] = Disc;
        this.qtyOrdered++;
        System.out.println("The disc is added to the cart");
        System.out.println("Number of Disc currently in the cart: " + this.qtyOrdered);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc Disc){
        int it, j;
        for(it = 0, j = 0; j < this.itemOrdered.length; ++j)
        {
            if(!(this.itemOrdered[j] == Disc)){
                this.itemOrdered[it] = this.itemOrdered[j];
                it++;
            }
        }
        this.itemOrdered = Arrays.copyOf(this.itemOrdered, it);
        System.out.println("Disc deleted");
        this.qtyOrdered--;
    }
    public float totalCost(){
        float TotalCost = 0.0f;
        for(int i = 0; i < this.qtyOrdered; ++i){
            TotalCost += this.itemOrdered[i].getCost();
        }
        return TotalCost;
    }
}
