package service;

import model.Offer;
import repository.OfferRepository;
public class OfferServiceImpl implements OfferService{

    private OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }

    @Override
    public void addOffer(Offer offer) {
        offerRepository.addOffer(offer);
    }

    @Override
    public Offer getOffer(String productId) {
        return offerRepository.getOffer(productId);
    }
}
