package test;

import model.FinalInvoice;
import model.Offer;
import model.Product;
import model.ProductInvoice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.*;
import service.*;

public class ShoppingCartServiceTest {

    OfferRepository offerRepository;
    OfferService offerService;
    ProductRepository productRepository;
    ProductService productService;
    ProductInvoiceRepository productInvoiceRepository;
    FinalInvoice finalInvoice;
    ProductInvoiceService productInvoiceService;
    ProductInvoice productInvoice;

    @Before
    public void init() {
        offerRepository = new OfferRepositoryImpl();
        offerService = new OfferServiceImpl(offerRepository);
        productRepository = new ProductRepositoryImpl();
        productService = new ProductServiceImpl(productRepository);
        finalInvoice = new FinalInvoice("TestCustomer", 0, null);
        productInvoiceRepository = new ProductInvoiceRepositoryImpl();
        productInvoiceService = new ProductInvoiceServiceImpl(offerRepository, productRepository, productInvoiceRepository);

    }

    @Test
    public void testAddOffers() {
        String productId = "TestOffer";
        Offer offer = new Offer(productId, 5, 25, Boolean.TRUE);
        offerService.addOffer(offer);
        Offer getOffer = offerService.getOffer(productId);
        Assert.assertTrue(productId.equals(getOffer.getProductId()));
        Assert.assertTrue(25 == (getOffer.getOfferedUnitPrice()));
        Assert.assertTrue(5 == (getOffer.getProductQty()));
        Assert.assertTrue(Boolean.TRUE == (getOffer.getActive()));
    }

    @Test
    public void testInvalidOffers() {
        Offer offer = new Offer("productId", 5, 25, Boolean.TRUE);
        offerService.addOffer(offer);
        Offer getOffer = offerService.getOffer("TestOffer");
        Assert.assertNull(getOffer);
    }

    @Test
    public void testAddProduct() {
        String productId = "TestProduct";
        Product product = new Product(productId, 30);
        productService.addProduct(product);
        Product getProduct = productService.getProduct(productId);
        Assert.assertTrue(productId.equals(getProduct.getProductID()));
        Assert.assertTrue(30 == (getProduct.getUnitPrice()));
    }

    @Test
    public void testInvalidProduct() {
        String productId = "TestProduct";
        Product product = new Product(productId, 30);
        productService.addProduct(product);
        Product getProduct = productService.getProduct("unkownProduct");
        Assert.assertNull(getProduct);
    }

    @Test
    public void testScanSingleProduct() {
        String productId = "ProductA";
        Offer offer = new Offer(productId, 3, 25, Boolean.TRUE);
        offerService.addOffer(offer);
        Product product = new Product(productId, 30);
        productService.addProduct(product);

        productInvoice = productInvoiceService.scanProduct(productId, finalInvoice);

        Assert.assertTrue(productInvoice.getProductID().equalsIgnoreCase("ProductA"));
        Assert.assertTrue(productInvoice.getTotalPrice() == 30D);
        Assert.assertTrue(productInvoice.getProductQty() == 1);
        Assert.assertTrue(productInvoice.getDiscountedPrice() == 0);
    }

    @Test
    public void testScanMultipleProducts() {
        String productId = "ProductA";
        Offer offer = new Offer(productId, 3, 25, Boolean.TRUE);
        offerService.addOffer(offer);
        Product product = new Product(productId, 30);
        productService.addProduct(product);

        for (int i = 0; i < offer.getProductQty(); i++) {
            productInvoice = productInvoiceService.scanProduct(productId, finalInvoice);
        }

        System.out.println(productInvoice.toString());
        Assert.assertTrue(productInvoice.getProductID().equalsIgnoreCase("ProductA"));
        Assert.assertTrue(productInvoice.getTotalPrice() == 75D);
        Assert.assertTrue(productInvoice.getProductQty() == 3);
        Assert.assertTrue(productInvoice.getDiscountedPrice() == 15);
    }

    @Test
    public void testNegativeScanMultipleProducts() {
        String productId = "ProductA";
        Offer offer = new Offer(productId, 1, 15, Boolean.TRUE);
        offerService.addOffer(offer);
        Product product = new Product(productId, 30);
        productService.addProduct(product);

        productInvoice = productInvoiceService.scanProduct(productId, finalInvoice);
        System.out.println(productInvoice);

        Assert.assertTrue(productInvoice.getProductID().equalsIgnoreCase("ProductA"));
        Assert.assertFalse(productInvoice.getTotalPrice() == 30D);
        Assert.assertTrue(productInvoice.getTotalPrice() == 15D);
    }

    @Test
    public void testNoOffersAvailable() {
        String productId = "ProductA";
        Product product = new Product(productId, 30);
        productService.addProduct(product);

        productInvoice = productInvoiceService.scanProduct(productId, finalInvoice);
        System.out.println(productInvoice);

        Assert.assertTrue(productInvoice.getProductID().equalsIgnoreCase("ProductA"));
        Assert.assertTrue(productInvoice.getTotalPrice() == 30D);
        Assert.assertFalse(productInvoice.getTotalPrice() == 15D);
    }

}
