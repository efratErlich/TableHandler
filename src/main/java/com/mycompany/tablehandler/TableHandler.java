package com.mycompany.tablehandler;

/**
 * The 'imports' here are for using in the library of:
 * <ul>
 * <li>{@link By} - for locating elements within a page using various selectors.</li>
 * <li>{@link WebDriver} - for controlling the web browser.</li>
 * <li>{@link WebElement} - for interacting with elements on a web page.</li>
 * <li>{@link ChromeDriver} - for implementing WebDriver with Google Chrome.</li>
 * </ul>
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Main class to handle operations involving web tables using Selenium WebDriver.
 */
public class TableHandler {

    /**
     * Main method to execute the operations:
     * <ul>
     * <li>Setup WebDriver for Chrome.</li>
     * <li>Read expected text from a CSV file.</li>
     * <li>Navigate to a web page containing a table.</li>
     * <li>Verify if a specific cell in the table contains the expected text.</li>
     * <li>Print the result and handle any exceptions.</li>
     * </ul>
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        // Set up the ChromeDriver property
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\פנחס ארליך\\Documents\\NetBeansProjects\\TableHandler\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            // Read the expected text from the CSV file
            String expected = FileUtil.readDataFromCSV();
            // Ensure the expected value is not null
            if (expected == null) {
                throw new RuntimeException("Expected text is null, cannot proceed.");
            }
            // Navigate to the web page containing the table
            driver.get("http://www.w3schools.com/html/html_tables.asp");
            // Locate the table element
            WebElement table = driver.findElement(By.id("customers"));
            // Verify if the cell contains the expected text
            boolean result = TableUtil.verifyTableCellText(table, 1, "Alfreds Futterkiste", 3, expected);
            // Print the result of the verification
            System.out.println("Result: " + result);
        } catch (Exception e) {
            /**
             * The 'catch' block handles any exceptions thrown during the 'try' block execution.
             * It prints the stack trace to the console, which helps in diagnosing what went wrong,
             * and rethrows the exception wrapped in a RuntimeException to ensure the application fails properly.
             */
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // Ensure the WebDriver instance is quit and cleaned up
            driver.quit();
        }
    }
}
