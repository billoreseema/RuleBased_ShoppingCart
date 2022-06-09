package data;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDataLoad {

    public static List<Product> readProductsDaosFromCSV(String fileName) {
        boolean firstLine = true;
        List<Product> productsDaos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"))) {
            String line = br.readLine();
            // loop until all lines are read 
            while (line != null) {

                if (firstLine) {
                    firstLine = false;
                    line = br.readLine();
                }
                String[] attributes = line.split(",");
                Product productsDao = createProductsDao(attributes);
                // adding ProductsDao into ArrayList
                productsDaos.add(productsDao);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Please place products.csv and offerCatalog.csv files in the jar directory  ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productsDaos;
    }

    private static Product createProductsDao(String[] metadata) {
        String name = metadata[0];
        int price = Integer.parseInt(metadata[1]);
        // create and return Product of this metadata
        return new Product(name, price);
    }
}
