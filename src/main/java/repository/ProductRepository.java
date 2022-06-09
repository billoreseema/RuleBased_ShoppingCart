package repository;

import model.Product;

public interface ProductRepository {

    void addProduct(Product product);
    Product getProduct(String productId);



}
