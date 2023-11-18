package Lab02;

import java.util.Comparator;

Enum SortOrder {
    ASC,
    DESC
}

class Product {
    protected String name;
    protected double price;
    protected String size;
    protected String suitableForGirls;

    @Override
    public String toString() {
        return "Product { " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", suitableForGirls='" + suitableForGirls + '\'' +
                " }";
    }

    static class StaticInnerComparator implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return Double.compare(o1.price, o2.price);
        }
    }

    public Product(String name, double price, String size, String suitableForGirls) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.suitableForGirls = suitableForGirls;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSuitableForGirls() {
        return suitableForGirls;
    }

    public void setSuitableForGirls(String suitableForGirls) {
        this.suitableForGirls = suitableForGirls;
    }

    public Product() {
    }
}

