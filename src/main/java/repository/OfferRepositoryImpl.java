package repository;

import model.Offer;
import java.util.HashMap;
import java.util.Map;

public class OfferRepositoryImpl implements OfferRepository {

    Map<String, Offer> offers = new HashMap<>();

    @Override
    public void addOffer(Offer offer) {

        offers.putIfAbsent(offer.getProductId(), offer);
    }

    @Override
    public Offer getOffer(String productId) {
        return offers.get(productId);
    }
}
