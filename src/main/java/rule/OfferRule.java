package rule;

import model.Offer;
import model.ProductInvoice;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "A product offer rule ", description = "Give discount based on product quantity" )

public class OfferRule {
    ProductInvoice productInvoice;
    Offer offer;

    public  OfferRule(ProductInvoice productInvoice, Offer offer){
        this.productInvoice = productInvoice;
        this.offer = offer;
    }
    @Condition
    public boolean offerQuantity(@Fact("quantity") ProductInvoice productInvoice){
        return (productInvoice.getProductQty() % (offer.getProductQty()) == 0);
    }

    @Action
    public void giveDiscount(@Fact("quantity") ProductInvoice productInvoice) {
            int mul = productInvoice.getProductQty() / (offer.getProductQty());
            double discountedPrice = (productInvoice.getUnitPrice() - offer.getOfferedUnitPrice()) * offer.getProductQty();
            productInvoice.setDiscountedPrice(discountedPrice * mul);
    }
}

