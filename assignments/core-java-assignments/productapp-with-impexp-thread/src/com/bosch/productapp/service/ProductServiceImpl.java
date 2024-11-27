package com.bosch.productapp.service;

import com.bosch.productapp.exception.NoProductFoundException;
import com.bosch.productapp.model.Product;
import com.bosch.productapp.model.ProductCategory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> products = new HashMap<>();

    @Override
    public int addProduct(Product product) {
        // TODO: VALIDATION
        product.setId(products.size() + 1);
        products.put(product.getId(), product);
        System.out.println("Product added successfully!!");
        return product.getId();
    }

    @Override
    public boolean updateProduct(int id, Product product) throws NoProductFoundException {
        if (products.containsKey(id)) {
            throw new NoProductFoundException("Invalid Product ID");
        }
        // TODO: VALIDATION
        product.setId(id);
        products.replace(id, product);
        System.out.println("Product updated successfully!!");
        return true;
    }

    @Override
    public boolean deleteProduct(int id) throws NoProductFoundException {
        if (products.containsKey(id)) {
            throw new NoProductFoundException("Invalid Product ID");
        }
        products.remove(id);
        System.out.println("Product deleted successfully!!");
        return true;
    }

    @Override
    public Product viewProduct(int id) throws NoProductFoundException {
        if (!products.containsKey(id)) {
            throw new NoProductFoundException("Invalid Product ID");
        }
        return products.get(id);
    }

    @Override
    public List<Product> viewAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void printStatistics() {
//        Map<Integer, Product> products = new HashMap<>();
//        products.put(100, new Product(100, ProductCategory.LAPTOPS, "Dell Inspiron", 5000, true));
//        products.put(101, new Product(101, ProductCategory.FURNITURES, "xyz", 30000, true));
//        products.put(102, new Product(102, ProductCategory.MOBILES, "Samsung", 35000, true));
//        products.put(103, new Product(103, ProductCategory.STATIONARY, "pen", 1000, true));
//        products.put(104, new Product(104, ProductCategory.LAPTOPS, "Hp", 35000, true));
//        products.put(105, new Product(105, ProductCategory.MOBILES, "Iphone 16", 6000, true));
//        products.put(106, new Product(106, ProductCategory.FURNITURES, "abc", 60000, true));
//        products.put(107, new Product(107, ProductCategory.LAPTOPS, "Mac", 75000, true));

        //No of products whose price more than 10k
        long countExpensiveProducts = products.values().stream()
                .filter(p -> p.getPrice() > 10000)
                .count();
        System.out.println("countExpensiveProducts:" + countExpensiveProducts);
        //Show no of products by product category with sorting
        Map<ProductCategory, Long> productsByCategory = products.values().stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        productsByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //Show avg price by product category
        Map<ProductCategory, Double> avgPriceByCategory = products.values().stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));
        System.out.println("avgPriceByCategory:" + avgPriceByCategory);
        //List product ids whose product name contains given name
        avgPriceByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        int totalProducts = products.size();
        long totalAvailable = products.values().stream().filter(Product::isActive).count();
        double averagePrice = products.values().stream().mapToDouble(Product::getPrice).average().orElse(0.0);

        System.out.println("countExpensiveProducts:" + countExpensiveProducts);
        System.out.println("Total products: " + totalProducts);
        System.out.println("Total available products: " + totalAvailable);
        System.out.println("Average price: " + averagePrice);
    }

    @Override
    public boolean importProducts() {
        String filePath = "./input/product-input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                ProductCategory category = ProductCategory.valueOf(values[1].toUpperCase());
                String name = values[2];
                double price = Double.parseDouble(values[3]);
                boolean active = Boolean.parseBoolean(values[4]);
                Product product = new Product(id, category, name, price, active);
                products.put(id, product);
            }
            System.out.println(Thread.currentThread().getName() + " - Importing products...");
            return true;
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error importing products: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean exportProducts() {
        String filePath = "./input/product-export.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("id,category,name,price,active\n");
            for (Product product : products.values()) {
                bw.write(product.getId() + "," + product.getCategory() + "," + product.getDescription() + "," + product.getPrice() + "," + product.isActive() + "\n");
            }
            System.out.println(Thread.currentThread().getName() + " - Exporting products...");
            return true;
        } catch (IOException e) {

            System.err.println("Error exporting products: " + e.getMessage());
            return false;
        }
    }
}
