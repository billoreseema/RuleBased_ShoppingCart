package model;

import java.util.List;

public class FinalInvoice {
    private String customerId;
    private double grandTotal;

    private List<model.ProductInvoice> productInvoiceList;

    public FinalInvoice(String customerId, double grandTotal, List<model.ProductInvoice> productInvoiceList) {
        this.customerId = customerId;
        this.grandTotal = grandTotal;
        this.productInvoiceList = productInvoiceList;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<model.ProductInvoice> getProductInvoiceList() {
        return productInvoiceList;
    }

    public void setProductInvoiceList(List<model.ProductInvoice> productInvoiceList) {
        this.productInvoiceList = productInvoiceList;
    }

    @Override
    public String toString() {
        return "FinalInvoice{" +
                "customerId='" + customerId + '\'' +
                ", grandTotal=" + grandTotal +
                ", productInvoiceList=" + productInvoiceList + "}";

    }
}
