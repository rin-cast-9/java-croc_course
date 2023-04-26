package org.example;

/**
 * This class represents a SellerHasProduct object which has seller id, product id, cost and amount attributes.
 * Here's the seller id attribute is a foreign key to a Seller object,
 * and the product id attribute is a foreign key to a Product object.
 */
public class SellerHasProduct {

    private int sellerId; // seller id
    private int productId; // product id
    private int cost; // cost
    private int amount; // amount

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

    public int getCost () {
        return this.cost;
    } // cost getter

    public void setCost (int cost) {
        this.cost = cost;
    } // cost setter

    public int getAmount () {
        return this.amount;
    } // amount getter

    public void setAmount (int amount) {
        this.amount = amount;
    } // amount setter

    @Override
    public String toString() {
        String string = "SellerHasProduct: [{sellerId:" + this.sellerId + "}, {productId:" + this.productId + "}, {cost:" + this.cost + "}, {amount:" + this.amount + "}]";
        return string;
    }

}
