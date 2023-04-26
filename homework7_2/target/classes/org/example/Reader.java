package org.example;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Reader {

    /**
     * Reads xml file which contains Product entries
     * @param file file to be parsed
     * @return ArrayList of Product
     * @throws Exception
     */
    static ArrayList <Product> readProductXML (File file) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file); // initialize document

        Element root = document.getDocumentElement(); // get the root element of the document

        if (!root.getTagName().equals("products")) { // if it's not products then it's over
            return null;
        }

        NodeList nodes = root.getChildNodes(); // get child nodes

        ArrayList <Product> products = new ArrayList <Product> (); // initialize array for storing entries data

        for (int i = 1; i < nodes.getLength(); i += 2) { // iterate over the nodes of the xml file
            Node node = nodes.item(i);

            Product product = new Product();

            if (node.hasAttributes()) {
                product.setId(Integer.parseInt(node.getAttributes().item(0).getNodeValue().split("x")[1])); // parse the attribute and get id
            }

            if (node.hasChildNodes()) {
                product.setName(node.getChildNodes().item(1).getTextContent()); // parse the node and get name
            }

            products.add(product); // add the element to the array
        }

        return products;
    }

    /**
     * Reads xml file which contains Seller entries
     * @param file file to be parsed
     * @return ArrayList of Seller
     * @throws Exception
     */
    static ArrayList <Seller> readSellerXML (File file) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file); // initialize document

        Element root = document.getDocumentElement(); // get the root element of the document

        if (!root.getTagName().equals("sellers")) { // if it's not sellers then it's over
            return null;
        }

        NodeList nodes = root.getChildNodes(); // get child nodes

        ArrayList <Seller> sellers = new ArrayList <Seller> (); // initialize array for storing entries data

        for (int i = 1; i < nodes.getLength(); i += 2) { // iterate over the nodes of the xml file
            Node node = nodes.item(i);

            Seller seller = new Seller();

            if (node.hasAttributes()) {
                seller.setId(Integer.parseInt(node.getAttributes().item(0).getNodeValue().split("x")[1])); // parse the attribute and get id
            }

            if (node.hasChildNodes()) {
                seller.setLastName(node.getChildNodes().item(1).getTextContent()); // parse the node and get last name
                seller.setFirstName(node.getChildNodes().item(3).getTextContent()); // and first name
            }

            sellers.add(seller); // add the element to the array
        }

        return sellers;
    }

    /**
     * Reads xml file which contains SellerHasProduct entries
     * @param file file to be parsed
     * @return ArrayList of SellerHasProduct
     * @throws Exception
     */
    static ArrayList <SellerHasProduct> readSellerHasProductXML (File file) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file); // initialize document

        Element root = document.getDocumentElement(); // get the root element of the document

        if (!root.getTagName().equals("sellerHasProductEntries")) { // if it's not sellerHasProductEntries then it's over
            return null;
        }

        NodeList nodes = root.getChildNodes(); // get child nodes

        ArrayList <SellerHasProduct> sellerHasProductEntries = new ArrayList <SellerHasProduct> (); // initialize array for storing entries data

        for (int i = 1; i < nodes.getLength(); i += 2) { // iterate over the nodes of the xml file
            Node node = nodes.item(i);

            SellerHasProduct sellerHasProduct = new SellerHasProduct();

            if (node.hasAttributes()) {
                sellerHasProduct.setSellerId(Integer.parseInt(node.getAttributes().item(1).getNodeValue())); // parse the attribute and get seller id
                sellerHasProduct.setProductId(Integer.parseInt(node.getAttributes().item(0).getNodeValue())); // parse the attribute and get product id
            }

            if (node.hasChildNodes()) {
                sellerHasProduct.setCost(Integer.parseInt(node.getChildNodes().item(1).getTextContent())); // parse the node and get cost
                sellerHasProduct.setAmount(Integer.parseInt(node.getChildNodes().item(3).getTextContent())); // parse the node and get amount
            }

            sellerHasProductEntries.add(sellerHasProduct); // add the element to the array
        }

        return sellerHasProductEntries;
    }

    /**
     * Reads xml file which contains Sale entries
     * @param file file to be parsed
     * @return ArrayList of Sale
     * @throws Exception
     */
    static ArrayList <Sale> readSaleXML (File file) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file); // initialize document

        Element root = document.getDocumentElement(); // get the root element of the document

        if (!root.getTagName().equals("sales")) { // if it's not sales then it's over
            return null;
        }

        NodeList nodes = root.getChildNodes(); // get child nodes

        ArrayList <Sale> sales = new ArrayList <Sale> (); // initialize array for storing entries data

        for (int i = 1; i < nodes.getLength(); i += 2) { // iterate over the nodes of the xml file
            Node node = nodes.item(i);

            Sale sale = new Sale();

            if (node.hasAttributes()) {
                sale.setId(Integer.parseInt(node.getAttributes().item(0).getNodeValue().split("x")[1])); // parse the attribute and get id
            }

            if (node.hasChildNodes()) {
                sale.setSellerId(Integer.parseInt(node.getChildNodes().item(1).getTextContent())); // parse the node and get seller id
                sale.setProductId(Integer.parseInt(node.getChildNodes().item(3).getTextContent())); // parse the node and get product id
                sale.setSalesAmount(Integer.parseInt(node.getChildNodes().item(5).getTextContent())); // parse the node and get sales amount
                sale.setSaleDate(LocalDate.parse(node.getChildNodes().item(7).getTextContent())); // parse the node and get sale date
            }

            sales.add(sale); // add the element to the array
        }

        return sales;
    }

}
