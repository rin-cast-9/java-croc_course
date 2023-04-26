package org.example;

/**
 * This class represents a Product object which has id and name attributes.
 */
public class Product {

    private int id; // id
    private String name; // name

    public int getId () { // id getter
        return this.id;
    }

    public void setId (int id) { // id setter
        this.id = id;
    }

    public String getName () { // name getter
        return this.name;
    }

    public void setName (String name) { // name setter
        this.name = name;
    }

    @Override
    public String toString() {
        String string = "Product: [{id:" + this.id + "}, {name:" + this.name + "}]";
        return string;
    }

}
