package data;

import model.Offer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OfferDataLoad {

    public static List<Offer> loadOfferDataFromCSV(String fileName) {
        boolean firstLine = true;
        List<Offer> offerCatelogDaoList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"))) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) { // use string.split to load a string array with the values from
                // each line of // the file, using a comma as the delimiter
                if (firstLine) {
                    firstLine = false;
                    line = br.readLine();
                }


                String[] attributes = line.split(",");
                Offer offerCatelogDao = createOfferDao(attributes);
                // adding ProductsDao into ArrayList
                offerCatelogDaoList.add(offerCatelogDao);
                // read next line before looping // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Please place products.csv and offerCatelog.csv files in the jar directory  ");
        }
        return offerCatelogDaoList;
    }

    private static Offer createOfferDao(String[] metadata) {
        if((metadata.length >0)) {
            String productName = metadata[0];
            int offerCriteria = Integer.parseInt(metadata[1]);
            int offeredUnitPrice = Integer.parseInt(metadata[2]);
            // create and return ProductsDao of this metadata
            return new Offer(productName, offerCriteria, offeredUnitPrice, Boolean.TRUE);
        }
        return null;
    }
}
