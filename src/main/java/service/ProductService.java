package service;

import model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductService {
    private final static ArrayList<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone", 300000, 20, "beautiful"));
        products.add(new Product(2, "Samsung", 450000, 40, "beautiful"));
        products.add(new Product(3, "Oppo", 330000, 10, "beautiful"));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void sortGreat() {
        products.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
    }

    public void sortLess() {
        products.sort((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
    }

    public void downQuantity(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setQuantity(product.getQuantity() - 1);
            }
        }
    }
}
