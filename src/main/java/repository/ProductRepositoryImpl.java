package repository;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

    Map<String,Product>  productMap = new HashMap<>();

    @Override
    public void addProduct(Product product) {

        productMap.putIfAbsent(product.getProductID(),product);
    }

    @Override
    public Product getProduct(String productId) {
        return productMap.get(productId);
    }
}


