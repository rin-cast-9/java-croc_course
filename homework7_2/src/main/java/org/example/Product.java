package org.example;

public class Product {

    private int id;
    private String name;

    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String string = "Product: [{id:" + this.id + "}, {name:" + this.name + "}]";
        return string;
    }

}
