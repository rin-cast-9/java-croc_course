package org.example;

/**
 * This class represents a Seller object which has id, last and first name attributes.
 */
public class Seller {

    private int id; // id
    private String lastName; // last name
    private String firstName; // first name

    public int getId () {
        return this.id;
    } // id getter

    public void setId (int id) {
        this.id = id;
    } // id setter

    public String getLastName () {
        return this.lastName;
    } // last name getter

    public void setLastName (String lastName) {
        this.lastName = lastName;
    } // last name setter

    public String getFirstName () {
        return this.firstName;
    } // first name getter

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    } // first name setter

    @Override
    public String toString() {
        String string = "Seller: [{id:" + this.id + "}, {lastName:" + this.lastName + "}, {firstName:" + this.firstName + "}]";
        return string;
    }

}
