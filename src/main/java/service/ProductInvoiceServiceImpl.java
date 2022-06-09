package service;

import model.FinalInvoice;
import model.Offer;
import model.Product;
import model.ProductInvoice;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import repository.OfferRepository;
import repository.ProductInvoiceRepository;
import repository.ProductRepository;
import rule.OfferRule;


public class ProductInvoiceServiceImpl implements ProductInvoiceService {

    private OfferRepository offerRepository;
    private ProductRepository productRepository;

    private ProductInvoiceRepository productInvoiceRepository;

    private Facts facts;
    private OfferRule offerRule;
    private Rules rules;

    public ProductInvoiceServiceImpl(OfferRepository offerRepository, ProductRepository productRepository, ProductInvoiceRepository productInvoiceRepository) {
        this.offerRepository = offerRepository;
        this.productRepository = productRepository;
        this.productInvoiceRepository = productInvoiceRepository;
    }

    @Override
    public ProductInvoice scanProduct(String productId, FinalInvoice finalInvoice) {
        Product product = productRepository.getProduct(productId);
        try {

            if (product == null) {
                System.out.println("Invalid Product or Product is out of stock");
                return null;
            }

            Offer offer = offerRepository.getOffer(productId);

            ProductInvoice productInvoice = productInvoiceRepository.getProductInvoice(productId);

            if (productInvoice == null) {
                productInvoice = new ProductInvoice();
                productInvoice.setProductDetails(product);
                productInvoiceRepository.addProductInvoice(productInvoice);
            }

            productInvoice.setProductQty(productInvoice.getProductQty() + 1);

            //Rules
            facts = new Facts();
            facts.put("quantity", productInvoice);
            // define rules

            if(offer != null) {
                offerRule = new OfferRule(productInvoice, offer);
                rules = new Rules();
                rules.register(offerRule);

                // fire rules on known facts
                RulesEngine rulesEngine = new DefaultRulesEngine();
                rulesEngine.fire(rules, facts);
            }

            productInvoice.setTotalPrice();

            finalInvoice.setProductInvoiceList(productInvoiceRepository.getFinalProductInvoice());
            finalInvoice.setGrandTotal(finalInvoice.getProductInvoiceList().stream().mapToDouble(productInvoice1 -> productInvoice1.getTotalPrice()).sum());
            return productInvoice;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public void clearInvoice() {
        productInvoiceRepository.clearInvoice();
    }

    private void applyOffers(ProductInvoice productInvoice, Offer offer) {

        if (productInvoice.getProductQty() % (offer.getProductQty()) == 0) {
            int mul = productInvoice.getProductQty() / (offer.getProductQty());
            double discountedPrice = (productInvoice.getUnitPrice() - offer.getOfferedUnitPrice()) * offer.getProductQty();
            productInvoice.setDiscountedPrice(discountedPrice * mul);
        }
    }

}
