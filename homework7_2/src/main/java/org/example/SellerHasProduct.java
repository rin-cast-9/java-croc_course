package org.example;

public class SellerHasProduct {

    private int sellerId;
    private int productId;
    private int cost;
    private int amount;

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

    public int getCost () {
        return this.cost;
    }

    public void setCost (int cost) {
        this.cost = cost;
    }

    public int getAmount () {
        return this.amount;
    }

    public void setAmount (int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        String string = "SellerHasProduct: [{sellerId:" + this.sellerId + "}, {productId:" + this.productId + "}, {cost:" + this.cost + "}, {amount:" + this.amount + "}]";
        return string;
    }

}
