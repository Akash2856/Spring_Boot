package com.Spring.boot;

public class Order {
    private String customerName;
    private String productName;
    private String quantity;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
