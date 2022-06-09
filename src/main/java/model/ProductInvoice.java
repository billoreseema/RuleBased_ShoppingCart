package model;

public class ProductInvoice {

    private String productID;
    private int productQty;
    private double unitPrice;
    private double discountedPrice;
    private double totalPrice;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public void setTotalPrice() {
        this.totalPrice = (productQty * unitPrice) - this.discountedPrice;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setProductDetails(Product product) {
        this.productID = product.getProductID();
        this.unitPrice = product.getUnitPrice();
    }

    @Override
    public String toString() {
        return "ProductInvoice{" +
                "productID='" + productID + '\'' +
                ", productQty=" + productQty +
                ", unitPrice=" + unitPrice +
                ", discountedPrice=" + discountedPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
