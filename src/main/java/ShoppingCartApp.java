import data.DataInitializer;
import model.FinalInvoice;
import model.ProductInvoice;
import repository.*;
import service.*;

import java.util.*;

public class ShoppingCartApp {
    private ProductInvoiceRepository productInvoiceRepository;
    private OfferRepository offerRepository;
    private ProductRepository productRepository;
    private OfferService offerService;
    private ProductService productService;
    private ProductInvoiceService productInvoiceService;

    public static void main(String str[]) {

        ShoppingCartApp shoppingCartApp = new ShoppingCartApp();
        shoppingCartApp.init();

        shoppingCartApp.startBilling();
    }

    private void init() {
        productInvoiceRepository = new ProductInvoiceRepositoryImpl();
        offerRepository = new OfferRepositoryImpl();
        productRepository = new ProductRepositoryImpl();

        offerService = new OfferServiceImpl(offerRepository);
        productService = new ProductServiceImpl(productRepository);
        productInvoiceService = new ProductInvoiceServiceImpl(offerRepository, productRepository, productInvoiceRepository);

        DataInitializer.dataInit(productRepository, offerRepository);
    }

    private void startBilling() {

        FinalInvoice finalInvoice = new FinalInvoice("Test", 0, null);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scan product and Enter Bill to generate Bill");

        while (scanner.hasNextLine()) {
            {
                String productName = scanner.nextLine();

                //terminate the application run
                if (productName.equalsIgnoreCase("Exit")) {
                    System.out.println("Terminating current application session");
                    return;
                }

                if (!productName.equalsIgnoreCase("Bill")) {

                    //validating product
                    System.out.println("Product is : " + productName);

                    ProductInvoice productInvoice = productInvoiceService.scanProduct(productName, finalInvoice);
                    if (productInvoice == null) {
                        System.out.println("Please enter a valid product");
                        continue;
                    }

                    // finalInvoice.

                    System.out.println(productInvoice);
                    System.out.println("Total Price: " + finalInvoice.getGrandTotal());

                } else {
                    System.out.println("Please find the final bills is : " + finalInvoice.getGrandTotal());

                    if (finalInvoice.getProductInvoiceList() == null) {
                        System.out.println("Please Enter valid products before final billing OR Enter Exit");
                        continue;
                    }
                    finalInvoice.getProductInvoiceList().stream().forEach(productInvoice -> System.out.println(productInvoice));

                    System.out.println("Start new Billing  or type exit");
                    finalInvoice = new FinalInvoice("Test1", 0, null);
                    productInvoiceService.clearInvoice();
                }
            }
        }
    }

}