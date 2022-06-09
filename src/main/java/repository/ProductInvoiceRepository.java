package repository;

import model.ProductInvoice;

import java.util.List;

public interface ProductInvoiceRepository {

  void addProductInvoice(ProductInvoice productInvoice);
  ProductInvoice getProductInvoice(String productId);
  void clearInvoice();

  List<ProductInvoice> getFinalProductInvoice();

}
