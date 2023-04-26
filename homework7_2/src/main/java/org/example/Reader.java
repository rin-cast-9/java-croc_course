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
                product.setId(Integer.parseInt(node.getAttributes().item(0).getNodeValue().split("x")[1])); // parse the node and get id
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
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

        Element root = document.getDocumentElement();

        if (!root.getTagName().equals("sellers")) {
            return null;
        }

        NodeList nodes = root.getChildNodes();

        ArrayList <Seller> sellers = new ArrayList <Seller> ();

        for (int i = 1; i < nodes.getLength(); i += 2) {
            Node node = nodes.item(i);

            Seller seller = new Seller();

            if (node.hasAttributes()) {
                seller.setId(Integer.parseInt(node.getAttributes().item(0).getNodeValue().split("x")[1]));
            }

            if (node.hasChildNodes()) {
                seller.setLastName(node.getChildNodes().item(1).getTextContent());
                seller.setFirstName(node.getChildNodes().item(3).getTextContent());
            }

            sellers.add(seller);
        }

        return sellers;
    }

    static ArrayList <SellerHasProduct> readSellerHasProductXML (File file) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

        Element root = document.getDocumentElement();

        if (!root.getTagName().equals("sellerHasProductEntries")) {
            return null;
        }

        NodeList nodes = root.getChildNodes();

        ArrayList <SellerHasProduct> sellerHasProductEntries = new ArrayList <SellerHasProduct> ();

        for (int i = 1; i < nodes.getLength(); i += 2) {
            Node node = nodes.item(i);

            SellerHasProduct sellerHasProduct = new SellerHasProduct();

            if (node.hasAttributes()) {
                sellerHasProduct.setSellerId(Integer.parseInt(node.getAttributes().item(1).getNodeValue()));
                sellerHasProduct.setProductId(Integer.parseInt(node.getAttributes().item(0).getNodeValue()));
            }

            if (node.hasChildNodes()) {
                sellerHasProduct.setCost(Integer.parseInt(node.getChildNodes().item(1).getTextContent()));
                sellerHasProduct.setAmount(Integer.parseInt(node.getChildNodes().item(3).getTextContent()));
            }

            sellerHasProductEntries.add(sellerHasProduct);
        }

        return sellerHasProductEntries;
    }

    static ArrayList <Sale> readSaleXML (File file) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

        Element root = document.getDocumentElement();

        if (!root.getTagName().equals("sales")) {
            return null;
        }

        NodeList nodes = root.getChildNodes();

        ArrayList <Sale> sales = new ArrayList <Sale> ();

        for (int i = 1; i < nodes.getLength(); i += 2) {
            Node node = nodes.item(i);

            Sale sale = new Sale();

            if (node.hasAttributes()) {
                sale.setId(Integer.parseInt(node.getAttributes().item(0).getNodeValue().split("x")[1]));
            }

            if (node.hasChildNodes()) {
                sale.setSellerId(Integer.parseInt(node.getChildNodes().item(1).getTextContent()));
                sale.setProductId(Integer.parseInt(node.getChildNodes().item(3).getTextContent()));
                sale.setSalesAmount(Integer.parseInt(node.getChildNodes().item(5).getTextContent()));
                sale.setSaleDate(LocalDate.parse(node.getChildNodes().item(7).getTextContent()));
            }

            sales.add(sale);
        }

        return sales;
    }

}
