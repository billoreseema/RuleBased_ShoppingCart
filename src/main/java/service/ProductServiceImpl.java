package service;

import model.Product;
import repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public Product getProduct(String productId) {
        return productRepository.getProduct(productId);
    }
}
