package org.aadi.inventory_mgnt.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Component to initialize product data.
 */
@Component
public class ProductDataInitializer {

    @Autowired
    private ProductService productService;

    private Map<String, Integer> productIds = new HashMap<>();

    /**
     * Initialize sample product data.
     * 
     * @return a map of product names to their IDs
     */
    public Map<String, Integer> initializeProducts() {
        System.out.println("Initializing sample products...");

        createProduct("Milk", ProductType.DRINK, 100f);
        createProduct("Eggs", ProductType.MEAT, 10f);
        createProduct("Chicken", ProductType.MEAT, 250f);
        createProduct("Coca Cola", ProductType.DRINK, 150f);
        createProduct("Cucumber", ProductType.VEGGIE, 40f);
        createProduct("Spinach", ProductType.VEGGIE, 19.99f);
        createProduct("Ice Cream", ProductType.DESERT, 149.99f);
        createProduct("Gulaab Jamun", ProductType.DESERT, 99f);

        System.out.println("Sample products initialized");
        return new HashMap<>(productIds);
    }

    /**
     * Helper method to create a product.
     * 
     * @param name the name of the product
     * @param type the type of the product
     * @param price the price of the product
     */
    private void createProduct(String name, ProductType type, float price) {
        ProductsData productData = new ProductsData(0, name, type, price);
        ProductsData createdProduct = productService.createProduct(productData);
        productIds.put(name, createdProduct.id());
        System.out.println("Created product: " + name + " with ID: " + createdProduct.id());
    }
}