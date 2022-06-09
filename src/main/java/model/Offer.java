package model;

public class Offer {

    private String productId;
    private int productQty;
    private double offeredUnitPrice;
    private Boolean isActive;

    public Offer(String productId, int productQty, double offeredUnitPrice, Boolean isActive) {
        if (productQty > 0 && offeredUnitPrice > 0) {
            this.productId = productId;
            this.productQty = productQty;
            this.offeredUnitPrice = offeredUnitPrice;
            this.isActive = isActive;
        } else {
            System.out.println("For Product Id  " + productId + " and unit Price " + productQty +
                    " and offeredUnitPrice " + offeredUnitPrice + " should be more than 0 ");
        }
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getOfferedUnitPrice() {
        return offeredUnitPrice;
    }

    public void setOfferedUnitPrice(double offeredUnitPrice) {
        this.offeredUnitPrice = offeredUnitPrice;
    }


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


}
