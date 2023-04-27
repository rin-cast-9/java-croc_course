package org.example;

import java.io.File;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;


public class Main {

    // problem 1 -> (1 % 6 = 1)
    // problem 2 -> (1 % 3 = 1)
    // formats -> (1 % 4 = 1)

//    1. We start by grouping the SellerHasProduct entries by their corresponding Product, as before.
//    2. For each group of SellerHasProduct entries, we use the minBy() collector to find the entry with the minimum cost, as before.
//    3. We filter out any groups that have no entries (i.e. no SellerHasProduct entries for that Product), as before.
//    4. Finally, we use the toMap() collector to create a Map with each Product as the key and a Map.Entry object as the value. The Map.Entry object contains the corresponding seller's name and the minimum cost for that Product. We use another filter() method to find the SellerHasProduct entry that matches the minimum cost for each Product, as before. We then create a new Map.Entry object using the found seller's name and the minimum cost.
//    5. Note that we're using Seller objects to retrieve the names of the sellers. We use another filter() method to find the Seller object that matches the sellerId in each SellerHasProduct entry. We then create a new Map.Entry object using the found seller's first name, last name, and the minimum cost.
    public static Map <Product, SimpleEntry <String, Integer>> problem1 (ArrayList <SellerHasProduct> sellerHasProductEntries, final ArrayList <Product> products, final ArrayList <Seller> sellers) {
        Map <Product, SimpleEntry <String, Integer>> minCostByProduct = sellerHasProductEntries.stream()
                .collect(Collectors.groupingBy(shp -> products.stream()
                                .filter(p -> p.getId() == shp.getProductId())
                                .findFirst()
                                .orElse(null),
                        Collectors.minBy(Comparator.comparingInt(shp -> shp.getCost()))))
                .entrySet().stream()
                .filter(e -> e.getValue().isPresent())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> {
                            SellerHasProduct shp = sellerHasProductEntries.stream()
                                    .filter(s -> s.getProductId() == e.getKey().getId() && s.getCost() == e.getValue().get().getCost())
                                    .findFirst()
                                    .orElse(null);
                            Seller seller = sellers.stream()
                                    .filter(s -> s.getId() == shp.getSellerId())
                                    .findFirst()
                                    .orElse(null);
                            return new AbstractMap.SimpleEntry <> (seller.getFirstName() + " " + seller.getLastName(), e.getValue().get().getCost());
                        }
                ));

        return minCostByProduct;
    }

//    1. First, we group the sales by sale date and sum the sales amount for each date using groupingBy and summingInt collectors.
//    2. Then, we convert the map to a stream of entries and sort them by value in descending order using comparingByValue().reversed().
//    3. We limit the stream to top 5 entries using limit(5).
//    4. We map the stream to get only the sale dates using map(Map.Entry::getKey).
//    5. Finally, we collect the dates into a list using Collectors.toList().
    public static List <LocalDate> problem2 (final ArrayList <Sale> sales) {
        List <LocalDate> top5Dates = sales.stream()
                .collect(Collectors.groupingBy(Sale::getSaleDate, Collectors.summingInt(Sale::getSalesAmount)))
                .entrySet().stream()
                .sorted(Map.Entry.<LocalDate, Integer> comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return top5Dates;
    }

    public static void main(String[] args) throws Exception {

        // Initialize files
        File productxml = new File("src/Product.xml");
        File sellerxml = new File("src/Seller.xml");
        File sellerHasProductxml = new File("src/SellerHasProduct.xml");
        File salexml = new File("src/Sale.xml");

        // Initialize arrays of each table
        ArrayList <Product> products = null;
        ArrayList <Seller> sellers = null;
        ArrayList <SellerHasProduct> sellerHasProductEntries = null;
        ArrayList <Sale> sales = null;

        // parse them with xml parser
        products = Reader.readProductXML(productxml);
        sellers = Reader.readSellerXML(sellerxml);
        sellerHasProductEntries = Reader.readSellerHasProductXML(sellerHasProductxml);
        sales = Reader.readSaleXML(salexml);

        if ((products != null) && (sellers != null) && (sellerHasProductEntries != null) && (sales != null)) { // make sure that problem1() and problem2() get not null values
            // save the results of methods into corresponding collections
            Map <Product, SimpleEntry <String, Integer>> problem1 = problem1(sellerHasProductEntries, products, sellers);
            List <LocalDate> problem2 = problem2(sales);

            // write our json output
            File output1 = new File("src/output1.json");
            File output2 = new File("src/output2.json");
            Writer.writeProblem1JSON(problem1, output1);
            Writer.writeProblem2JSON(problem2, output2);
        }
        else {
            System.err.println("Couldn't read xml-file.");
        }

    }

}