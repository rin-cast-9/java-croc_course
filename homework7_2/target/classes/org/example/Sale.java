package org.example;

import java.time.LocalDate;

/**
 * This class represents a Sale object which has id, seller id, product id, sales amount and sale date attributes.
 * Here's the seller id is a foreign key to a Seller object,
 * and the product id is a foreign key to a Product object.
 */
public class Sale {

    private int id; // id
    private int sellerId; // seller id
    private int productId; // product id
    private int salesAmount; // sales amount
    private LocalDate saleDate; // sale date

    public int getId () {
        return this.id;
    } // id getter

    public void setId (int id) {
        this.id = id;
    } // id setter

    public int getSellerId () {
        return this.sellerId;
    } // seller id getter

    public void setSellerId (int sellerId) {
        this.sellerId = sellerId;
    } // seller id setter

    public int getProductId () {
        return this.productId;
    } // product id getter

    public void setProductId (int productId) {
        this.productId = productId;
    } // product id setter

    public int getSalesAmount () {
        return this.salesAmount;
    } // sales amount getter

    public void setSalesAmount (int salesAmount) {
        this.salesAmount = salesAmount;
    } // sales amount setter

    public LocalDate getSaleDate () {
        return this.saleDate;
    } // sale date getter

    public void setSaleDate (LocalDate saleDate) {
        this.saleDate = saleDate;
    } // sale date setter

    @Override
    public String toString() {
        String string = "Sale: [{id:" + this.id + "}, {sellerId:" + this.sellerId + "}, {productId:" + this.productId + "}, {salesAmount:" + this.salesAmount + "}, {saleDate:" + this.saleDate + "}]";
        return string;
    }

}
