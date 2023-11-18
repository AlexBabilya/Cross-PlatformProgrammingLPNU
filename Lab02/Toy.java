public class Toy extends Product {
    private String ageGroup;

    public Toy(String name, double price, String size, String suitableForGirls, String ageGroup) {
        super(name, price, size, suitableForGirls);
        this.ageGroup = ageGroup;
    }

    @Override
    public String toString() {
        return "Toy { " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", suitableForGirls='" + suitableForGirls + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                " }";
    }
}

