package data;

import model.Offer;
import model.Product;
import repository.OfferRepository;
import repository.ProductRepository;
import java.util.List;

public class
DataInitializer {

    private OfferDataLoad offerDataLoad;
    private ProductDataLoad productDataLoad;
    List<Product> productsList;
    List<Offer> offerCatelogList;

    private void init() {
        offerDataLoad = new OfferDataLoad();
        productDataLoad = new ProductDataLoad();
        productsList = productDataLoad.readProductsDaosFromCSV("products.csv");
        offerCatelogList = OfferDataLoad.loadOfferDataFromCSV("offerCatelog.csv");

        if (!(productsList.size() > 0 )) {
            System.out.println("No products and Offers available so exiting the process");
            System.exit(0);
        }

    }

    public static void dataInit(ProductRepository productRepository, OfferRepository offerRepository) {

        DataInitializer dataInitializer = new DataInitializer();
        try {
            dataInitializer.init();
            dataInitializer.productsList.stream().forEach(product -> productRepository.addProduct(product));
            dataInitializer.offerCatelogList.stream().forEach(offer -> offerRepository.addOffer(offer));
        } catch (Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }

}
