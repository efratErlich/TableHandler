package com.mycompany.tablehandler;

/**
 * The 'imports' here are for using in the library of:
 * <ul>
 * <li>{@link BufferedReader} - for efficiently reading text from a file.</li>
 * <li>{@link InputStream} - for representing an input stream of bytes.</li>
 * <li>{@link InputStreamReader} - for converting bytes into characters.</li>
 * </ul>
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utility class for file operations.
 */
public class FileUtil {

    /**
     * Reads the first line from a CSV file named "products.csv" located in the project's resources.
     *
     * @return the first line from the CSV file, or {@code null} if an error occurs.
     */
    public static String readDataFromCSV() {
        ClassLoader classLoader = FileUtil.class.getClassLoader(); // Adjusted to use FileUtil class loader

        /**
         * The 'try' & 'catch' blocks are used to handle potential exceptions that may occur while reading the file.
         *
         * The 'try' block attempts to open and read the CSV file. If the file or the input stream is not found,
         * or if there is an issue reading the file, an exception may be thrown. The 'catch' block handles these exceptions
         * by printing the stack trace to help diagnose the issue, preventing the program from crashing unexpectedly.
         */
        try (InputStream inputStream = classLoader.getResourceAsStream("products.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                throw new RuntimeException("CSV file not found in resources");
            }

            String line = reader.readLine(); // Read the first line of the CSV file
            System.out.println(line); // Output the line to the console
            return line; // Return the line read from the file
        } catch (Exception e) {
            /**
             * The 'catch' block handles any exceptions thrown during the 'try' block execution.
             * It prints the stack trace to the console, which helps in diagnosing what went wrong.
             */
            e.printStackTrace();
        }
        return null; // Return {@code null} if an exception occurs
    }
}
