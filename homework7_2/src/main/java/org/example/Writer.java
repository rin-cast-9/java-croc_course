package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * Writes to json files
 */
public class Writer {

    /**
     * Specifically solves the problem 1, parses it into json file
     * @param data data to be parsed
     * @param file destination file
     * @throws IOException
     */
    public static void writeProblem1JSON (final Map<Product, AbstractMap.SimpleEntry<String, Integer>> data, File file) throws IOException {
        OutputStream outputStream = new FileOutputStream(file, true); // initialize outputStream, since createGenerator() works with it
        try (JsonGenerator jsonGenerator = new JsonFactory().createGenerator(outputStream)) { // try-with-resources where we initialize jsonGenerator
            for (var a : data.entrySet()) { // iterate over the data-collection
                jsonGenerator.writeStartObject(); // start of entry
                jsonGenerator.writeStringField("product", a.getKey().getName()); // get the name of the product
                jsonGenerator.writeStringField("seller", a.getValue().getKey()); // get the name of the seller
                jsonGenerator.writeNumberField("cost", a.getValue().getValue()); // get the cost of the product
                jsonGenerator.writeEndObject(); // end of entry
            }
        }
    }

    /**
     * Specifically solves the problem 2, parses it into json file
     * @param data data to be parsed
     * @param file destination file
     * @throws IOException
     */
    public static void writeProblem2JSON (final List <LocalDate> data, File file) throws IOException {
        OutputStream outputStream = new FileOutputStream(file, true); // initialize outputStream, since createGenerator() works with it
        try (JsonGenerator jsonGenerator = new JsonFactory().createGenerator(outputStream)) { // try-with-resources where we initialize jsonGenerator
            for (var a : data) { // iterate over the data-collection
                jsonGenerator.writeStartObject(); // start of entry
                jsonGenerator.writeStringField("date", a.toString()); // get the date
                jsonGenerator.writeEndObject(); // end of entry
            }
        }
    }

}
