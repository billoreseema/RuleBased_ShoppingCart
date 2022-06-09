package repository;

import model.Offer;
import model.Product;

import java.util.List;

public interface OfferRepository {
    void addOffer(Offer offer);

    Offer getOffer(String productId);
}
