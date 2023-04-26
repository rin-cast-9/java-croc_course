package org.example;

import java.time.LocalDate;

public class Sale {

    private int id;
    private int sellerId;
    private int productId;
    private int salesAmount;
    private LocalDate saleDate;

    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getSellerId () {
        return this.sellerId;
    }

    public void setSellerId (int sellerId) {
        this.sellerId = sellerId;
    }

    public int getProductId () {
        return this.productId;
    }

    public void setProductId (int productId) {
        this.productId = productId;
    }

    public int getSalesAmount () {
        return this.salesAmount;
    }

    public void setSalesAmount (int salesAmount) {
        this.salesAmount = salesAmount;
    }

    public LocalDate getSaleDate () {
        return this.saleDate;
    }

    public void setSaleDate (LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        String string = "Sale: [{id:" + this.id + "}, {sellerId:" + this.sellerId + "}, {productId:" + this.productId + "}, {salesAmount:" + this.salesAmount + "}, {saleDate:" + this.saleDate + "}]";
        return string;
    }

}
