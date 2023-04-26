package org.example;

public class Seller {

    private int id;
    private String lastName;
    private String firstName;

    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getLastName () {
        return this.lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        String string = "Seller: [{id:" + this.id + "}, {lastName:" + this.lastName + "}, {firstName:" + this.firstName + "}]";
        return string;
    }

}
