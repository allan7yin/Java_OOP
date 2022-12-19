public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantity;

    public StockItem(String name, double price) {
        this(name, price, 0);
    }

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantity + quantity;
        if (newQuantity >= 0) {
            this.quantity = newQuantity;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof StockItem)) {
            return false;
        }

        return this.name.equals(((StockItem) other).getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public int compareTo(StockItem other) {
        if (this == other) {
            return 0;
        }

        if (other != null) {
            return this.name.compareTo(other.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }

}
