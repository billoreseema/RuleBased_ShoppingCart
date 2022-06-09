package model;

public class Product {

    private String productID;
    private int productQty;
    private double unitPrice;

    public Product(String productID, double unitPrice) {
        if (unitPrice > 0 && productID != null && !productID.isEmpty() && !(productID == " ")) {
            this.productID = productID;
            this.unitPrice = unitPrice;
        } else {
            System.out.println("Product Id:  " + productID + " cant not be null and unit Price can not be negative " + unitPrice);
        }
    }
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
