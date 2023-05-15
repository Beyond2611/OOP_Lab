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
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        if(this.qtyOrdered + dvdList.length >= MAX_NUMBER_ORDERED){
            System.out.println("The numbers of Disc in the list if added will be larger than the max quantity of discs the cart allow, please remove some items");
        }
        for(DigitalVideoDisc item : dvdList){
            this.itemOrdered[this.qtyOrdered] = item;
            this.qtyOrdered++;
        }
        System.out.println("The disc(s) are added to the cart");
        System.out.println("Number of Discs currently in the cart: " + this.qtyOrdered);
    }
    public void addDigitalVideoDisc(DigitalVideoDisc Disc1, DigitalVideoDisc Disc2){
        if(this.qtyOrdered + 2 == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is Almost Full");
            return;
        }
        this.itemOrdered[this.qtyOrdered] = Disc1;
        this.qtyOrdered++;
        this.itemOrdered[this.qtyOrdered] = Disc2;
        this.qtyOrdered++;
        System.out.println("The discs are added to the cart");
        System.out.println("Number of Disc currently in the cart: " + this.qtyOrdered);
    }
    /*public void addDigitalVideoDisc(DigitalVideoDisc... Discs){
        if(this.qtyOrdered + Discs.length > MAX_NUMBER_ORDERED){
            System.out.println("The numbers of Disc in the list if added will be larger than the max quantity of discs the cart allow, please remove some items");
        }
        for(DigitalVideoDisc item : Discs){
            this.itemOrdered[this.qtyOrdered] = item;
            this.qtyOrdered++;
        }
        System.out.println("The disc(s) are added to the cart");
        System.out.println("Number of Discs currently in the cart: " + this.qtyOrdered);
    }*/
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

    public void printCart() {
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items");
        for (int i = 0; i < this.qtyOrdered; ++ i){
            System.out.print(i + 1);
            System.out.println(this.itemOrdered[i].toString());
        }
        System.out.println("Total cost: " + this.totalCost() + "$");
        System.out.println("************************************************");
    }
}
