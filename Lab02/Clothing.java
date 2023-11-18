public class Clothing extends Product {
    private String material;

    public Clothing(String name, double price, String size, String suitableForGirls, String material) {
        super(name, price, size, suitableForGirls);
        this.material = material;
    }

    @Override
    public String toString() {
        return "Clothing { " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", suitableForGirls='" + suitableForGirls + '\'' +
                ", material='" + material + '\'' +
                " }";
    }
}

