package service;

import model.FinalInvoice;
import model.Product;
import model.ProductInvoice;

import java.util.List;

public interface ProductInvoiceService {

    ProductInvoice scanProduct(String productId, FinalInvoice finalInvoice);

    public void clearInvoice();
}
