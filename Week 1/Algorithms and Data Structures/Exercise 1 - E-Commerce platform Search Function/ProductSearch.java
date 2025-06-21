import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }

}

public class ProductSearch {

    // Linear search
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary search
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == productId) {
                return products[mid];
            }

            if (products[mid].productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        // Taking input from the user for number of products
        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine();

        Product[] products = new Product[numberOfProducts];

        // Taking input for the product details from the user
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.print("Enter product ID for product " + (i + 1) + ": ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter product name for product " + (i + 1) + ": ");
            String productName = scanner.nextLine();

            System.out.print("Enter category for product " + (i + 1) + ": ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }

        // Sort the products array for binary search
        Arrays.sort(products, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                if (a.productId < b.productId)
                    return -1;
                else if (a.productId > b.productId)
                    return 1;
                else
                    return 0;
            }
        });

        System.out.print("Enter the product ID to search: ");
        int searchId = scanner.nextInt();

        Product foundProductwithLinear = linearSearch(products, searchId);
        if (foundProductwithLinear != null) {
            System.out.println("Product found with Linear Search: " + foundProductwithLinear);
        } else {
            System.out.println("Product not found");
        }

        Product foundProductwithBinary = binarySearch(products, searchId);
        if (foundProductwithBinary != null) {
            System.out.println("Product found with Binary Search: " + foundProductwithBinary);
        } else {
            System.out.println("Product not found");
        }

        scanner.close();
    }
}
