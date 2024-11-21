package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ProductImportSerializer {

    public static void main(final String[] args) throws FileNotFoundException {

        String productDetail = readProductDetailFromFile();
        Product product = createProduct(productDetail);
        serializeProductToFile(product);
    }

    public static String readProductDetailFromFile() throws FileNotFoundException {
        String productDetail = "";
        try (Scanner scanner = new Scanner(new FileReader("./input/products.txt"))) {
            while (scanner.hasNextLine()) {
                productDetail += scanner.nextLine() + "\n";
            }
            System.out.println(productDetail);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return productDetail;
    }

    public static Product createProduct(String productDetail) {
        String[] productDetails = productDetail.split(",");
        int id = Integer.parseInt(productDetails[0]);
        ProductCategory category = ProductCategory.valueOf(productDetails[1]);
        String description = productDetails[2];
        double price = Double.parseDouble(productDetails[3]);
        boolean active = Boolean.parseBoolean(productDetails[4]);

        return new Product(id , category , description , price, active);
    }

    public static void serializeProductToFile(Product product) {
        try (FileOutputStream fileOut = new FileOutputStream("products.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(product);
            System.out.println("Product objects serialized successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}