/**
 * @author Zafarzhon Odilov
 * @URL https://github.com/zafarzhon
 */
public class Main {
    private static Product[] products = new Product[]{new Product("Chick Peas - Canned", 79.08, 1),
            new Product("Cheese - Brie,danish", 89.75, 5),
            new Product("Pepper - Black, Crushed", 74.93, 8),
            new Product("Glass - Juice Clear 5oz 55005", 21.27, 2),
            new Product("Cornstarch", 56.45, 7),
            new Product("Lettuce - Baby Salad Greens", 14.89, 5),
            new Product("Knife Plastic - White", 94.47, 5),
            new Product("Lettuce - Sea / Sea Asparagus", 37.0, 7),
            new Product("Lotus Root", 33.27, 2),
            new Product("Pork - Liver", 70.97, 8)};

    public static void main(String[] args) {
        for (Product product : products) {
            System.out.println(product);

        }

    }

}
