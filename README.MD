# Exercise Description

This project includes Java code that uses Selenium WebDriver to perform actions on HTML tables in the Google Chrome browser. The project is divided into three main classes:

## Installation

### Selenium WebDriver Installation

#### Adding Selenium WebDriver to the Project
1. Add the following dependency to your `pom.xml` file to include Selenium WebDriver in your project:
   ```xml
   <dependency>
       <groupId>org.seleniumhq.selenium</groupId>
       <artifactId>selenium-java</artifactId>
       <version>4.9.0</version>
   </dependency>
   ```
#### Installing ChromeDriver
1. Download the appropriate ChromeDriver for your version of Google Chrome from [ChromeDriver Downloads](https://sites.google.com/a/chromium.org/chromedriver/downloads).
2. Place the `chromedriver.exe` file in the appropriate directory within your project.
3. Set the properties for ChromeDriver in the code using:
   ```java
   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    

#### Running the Project by a command
To run the main by a command: 
```maven
    mvn exec:java 
```

The result will be printed in the Console.

## Classes

### FileUtil
- **Description**: Responsible for reading data from a CSV file.
- **Main Function**: `readDataFromCSV()`
    - Reads the first row from the file and returns it as a string.
    - Throws an exception in case of issues.

### TableUtil
- **Description**: Performs actions on HTML tables using XPath.
- **Main Functions**:
    - `verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText)`
        - Verifies if the text in a specific cell matches the expected text.
    - `getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText)`
        - Retrieves the text from a specific cell in the table based on given criteria.
    - Throws an exception in case of issues locating the cell.

### TableHandler
- **Description**: Manages the overall process of checking the table in the browser.
- **Main Function**: `main(String[] args)`
    - Sets the path for ChromeDriver.
    - Reads data from the file.
    - Opens the web page and performs the required checks on the table.
    - Prints the result of the check.
    - Throws an exception in case of issues and eventually cancels the operation.
