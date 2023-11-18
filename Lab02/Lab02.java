import java.util.ArrayList;

public class Lab02 {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Toy("Barbie Doll", 25.99, "Small", "Yes", "3-5 years"));
        products.add(new Toy("LEGO Set", 49.99, "Medium", "Yes", "6-10 years"));
        products.add(new Toy("Remote Control Car", 29.99, "Large", "No", "8-12 years"));
        products.add(new Clothing("Dress", 34.99, "Medium", "Yes", "Cotton"));
        products.add(new Clothing("T-shirt", 12.99, "Small", "Yes", "Polyester"));
        products.add(new Clothing("Jeans", 24.99, "Large", "No", "Denim"));

        StoreManager manager = new StoreManager();

        System.out.println("\nProducts Suitable for Girls:");
        ArrayList<Product> girlsProducts = manager.searchForGirls(products);
        girlsProducts.forEach(System.out::println);

        System.out.println("\nSorting by Price (Ascending, Static Inner):");
        manager.sortByPriceStaticInner(products, SortOrder.ASC);
        products.forEach(System.out::println);

        System.out.println("\nSorting by Size (Descending, Lambda):");
        manager.sortBySizeLambda(products, SortOrder.DESC);
        products.forEach(System.out::println);
        
        System.out.println("\nSorting by Price (Ascending, Static):");
        manager.sortByPriceInner(products, SortOrder.ASC);
        products.forEach(System.out::println);
        
        System.out.println("\nSorting by Name (Ascending, Anonymous):");
        manager.sortByNameAnonymous(products, SortOrder.ASC);
        products.forEach(System.out::println);
        
        System.out.println("\nSorting by Girls (Ascending, Anonymous):");
        ArrayList<Product> result = manager.searchForGirlsTrue(products);
        result.forEach(System.out::println);
    }
}

