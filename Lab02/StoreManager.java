import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;

public class StoreManager {
    class PriceComparatorInner implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return Double.compare(o1.getPrice(), o2.getPrice());
        }
    }

    void sortByPriceInner(ArrayList<Product> products, SortOrder order) {
        PriceComparatorInner comparator = new PriceComparatorInner();

        if (order == SortOrder.ASC) {
            products.sort(comparator);
        } else {
            products.sort(comparator.reversed());
        }
    }

    void sortByPriceStaticInner(ArrayList<Product> products, SortOrder order) {
        if (order == SortOrder.ASC) {
            products.sort(new Product.StaticInnerComparator());
        } else {
            products.sort(new Product.StaticInnerComparator().reversed());
        }
    }

    void sortBySizeLambda(ArrayList<Product> products, SortOrder order) {
        if (order == SortOrder.ASC) {
            products.sort(Comparator.comparing(Product::getSize));
        } else {
            products.sort(Comparator.comparing(Product::getSize, Comparator.reverseOrder()));
        }
    }
    
   void sortByNameAnonymous(ArrayList<Product> products, SortOrder order) {
        if (order == SortOrder.ASC) {
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        } else {
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
        }
    }  

    ArrayList<Product> searchForGirls(ArrayList<Product> products) {
        return products
                .stream()
                .filter(x -> "Yes".equalsIgnoreCase(x.getSuitableForGirls()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<Product> searchForGirlsTrue(ArrayList<Product> products) {
        ArrayList<Product> result = new ArrayList<>(); 
        for (Product product : products) {
            if (product.getSuitableForGirls().equals("Yes")) { 
                result.add(product);
            }
        }
        return result;
    }

}

