package com.mycompany.tablehandler;

/**
 * The 'imports' here are for using in the library of:
 * <ul>
 * <li>{@link By} - for locating elements within a page using various selectors.</li>
 * <li>{@link WebElement} - for interacting with elements on a web page.</li>
 * </ul>
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Utility class for operations on HTML tables using Selenium WebDriver.
 */
public class TableUtil {

    /**
     * Verifies if the text in a specific cell of an HTML table matches the expected text.
     *
     * @param table           the {@link WebElement} representing the table.
     * @param searchColumn    the column index to search for the cell containing the {@code searchText} (1-based index).
     * @param searchText      the text to search for in the specified column.
     * @param returnColumnText the column index from which to retrieve the text (1-based index).
     * @param expectedText    the expected text to compare with the actual text in the cell.
     * @return {@code true} if the actual text matches the expected text, {@code false} otherwise.
     */
    public static boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        try {
            /**
             * The 'try' block here is used to attempt to retrieve and verify the text from a specific cell in the HTML table.
             * If there are any issues during the process (e.g., the cell is not found), an exception might be thrown.
             */
            String actualText = getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
            return actualText != null && actualText.equals(expectedText);
        } catch (Exception e) {
            /**
             * The 'catch' block handles any exceptions thrown during the 'try' block execution.
             * It prints the stack trace to the console, which helps in diagnosing what went wrong.
             */
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves the text from a specific cell in an HTML table based on the search criteria.
     *
     * @param table           the {@link WebElement} representing the table.
     * @param searchColumn    the column index to search for the cell containing the {@code searchText} (1-based index).
     * @param searchText      the text to search for in the specified column.
     * @param returnColumnText the column index from which to retrieve the text (1-based index).
     * @return the text from the specified cell.
     * @throws Exception if the cell is not found.
     */
    public static String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        String xpath = String.format(".//tr[td[%d][text()='%s']]/td[%d]", searchColumn, searchText, returnColumnText);
        WebElement cell = table.findElement(By.xpath(xpath));
        if (cell != null) {
            return cell.getText();
        }
        /**
         * Throws an exception if the specified cell is not found.
         * This ensures that the caller of the function is aware of the failure to find the cell.
         */
        throw new RuntimeException("Cell not found");
    }
}
