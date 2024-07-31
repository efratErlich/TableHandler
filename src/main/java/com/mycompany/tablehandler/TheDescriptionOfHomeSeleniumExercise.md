Exercise Description:
This project includes Java code that uses Selenium WebDriver to perform actions on HTML tables in the Google Chrome browser. The project is divided into three main classes:

Classes:

FileUtil: Responsible for reading data from a CSV file.
TableUtil: Performs actions on HTML tables using XPath.
TableHandler: Manages the overall process of checking the table in the browser.
Installation:
Selenium WebDriver Installation:

Adding Selenium WebDriver to the Project:

I downloaded the Selenium WebDriver JAR file from the Selenium website.
I added the JAR file to the project's Classpath to enable Selenium functions.
Installing ChromeDriver:

I downloaded the appropriate ChromeDriver for my version of Google Chrome from ChromeDriver Downloads.
I placed the chromedriver.exe file in the appropriate directory within my project.
I set the properties for ChromeDriver in the code using:
{
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
}
*Note: 
    I wrote the navigation to my file, it's a ranking between one computer and another.
Libraries in Use:

Selenium WebDriver:

By: Used for locating elements on the page with various selectors (XPath, ID, etc.).
WebDriver: Controls the browser and performs actions.
WebElement: Represents an element on the page and allows interaction with it.
ChromeDriver: An implementation of WebDriver for Google Chrome.
Java IO:

BufferedReader: Efficiently reads text from a file.
InputStream: Represents a byte input stream.
InputStreamReader: Converts bytes to characters for reading.
Code Usage:

FileUtil.java:

Description: This class is responsible for reading the first row from a CSV file located in the project's resources directory.
Main Function: readDataFromCSV()
It reads the first row from the file and returns it as a string.
It throws an exception in case of file reading issues.
TableUtil.java:

Description: This class includes functions for performing actions on HTML tables using Selenium WebDriver.
Main Functions:
verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText): Verifies if the text in a specific cell matches the expected text.
getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText): Retrieves the text from a specific cell in the table based on given criteria.
It throws an exception in case of issues locating the cell.
TableHandler.java:

Description: This class performs the overall process: setting up WebDriver, reading data from a CSV file, accessing a web page, and verifying the content of the table.
Main Function: main(String[] args)
It sets the path for ChromeDriver.
It reads data from the file.
It opens the web page and performs the required checks on the table.
It prints the result of the check.
It throws an exception in case of issues and eventually cancels the operation.
Improvement Topics (If More Time Was Available):

Advanced Error Handling:

Improve error handling by using logs instead of direct print statements.
Add custom error handling to deal with various scenarios.
Support for Different CSV Files:

Extend functions to read from multiple files or different formats.
Performance Optimization:

Enhance performance by optimizing XPath queries and reducing the number of WebDriver calls.
Writing Automated Tests:

Create automated tests for the functions in the code, including integration tests.
Support for Additional Browsers:

Expand support to other browsers beyond Chrome, such as Firefox and Edge.
Code Security Improvement:

Add security controls when reading and writing files.
Additional Notes:

Notes: The code is written to demonstrate how to use Selenium WebDriver and Java for reading and handling HTML tables.