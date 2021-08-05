/*
 * Fred Fan and Daniel Peng
 * Jan 11, 2021
 * Utility class, includes functions that can load files
 */
package Evader.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author FRED
 */
public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            // first field of map file which is length of hearts
            String line;
            while ((line = br.readLine()) != null) {
                // build the strings in file
                builder.append(line + "\n");
            }
            // close file stream
            br.close();
        } catch (IOException e) {
            e.printStackTrace(); // handles exceptions
        }
        // return string we've made with builder
        return builder.toString();
    }

    public static void outPutStringAsFile(String path, String score) {
        // puts score into file so it can always be remembered
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(score);
            pw.close(); // close stream
        } catch (IOException e) {

        }
    }

    // convert the string numbers in file to ints
    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
