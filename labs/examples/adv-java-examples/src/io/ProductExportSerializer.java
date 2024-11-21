package io;

import javax.swing.plaf.synth.SynthLookAndFeel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ProductExportSerializer {

    public static void main(final String[] args) {

        Product product = deserializeProduct();

        writeProductDetailsToFile(product);
    }

    public static Product deserializeProduct() {
        Product product = null;
        try (FileInputStream in = new FileInputStream("./output/products.ser")) {
            ObjectInputStream obIn = new ObjectInputStream(in);
            product = (Product) obIn.readObject();
            System.out.println("Deserialized product object");

        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return product;
    }

    public static void writeProductDetailsToFile(Product product) {
        File file = new File("./output/product-output.txt");
        try (FileWriter out = new FileWriter(file)) {
            out.write(getProductDetails(product));
            System.out.println("Serialized product details to file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getProductDetails(Product product) {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getId());
        sb.append(product.getDescription());
        sb.append(product.getPrice());
        sb.append(product.isActive());
        return sb.toString();
    }
}