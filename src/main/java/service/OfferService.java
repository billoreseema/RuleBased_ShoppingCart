package service;

import model.Offer;

import java.util.List;

public interface OfferService {
    void addOffer(Offer offer);
    Offer getOffer(String productId);
}
