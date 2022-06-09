package repository;

import model.Product;
import model.ProductInvoice;

import java.util.*;

public class ProductInvoiceRepositoryImpl implements ProductInvoiceRepository{

    private Map<String,ProductInvoice> productInvoiceMap;

    public ProductInvoiceRepositoryImpl() {
        this.productInvoiceMap = new HashMap<>();
    }

    public void addProductInvoice(ProductInvoice productInvoice){
        productInvoiceMap.put(productInvoice.getProductID(),productInvoice);
        
    }
    public ProductInvoice getProductInvoice(String productId){
        return  productInvoiceMap.get(productId);
    }

    @Override
    public List<ProductInvoice> getFinalProductInvoice() {

        return new LinkedList<>(productInvoiceMap.values());

    }

    @Override

    public void clearInvoice(){
        productInvoiceMap.clear();
    }

}
