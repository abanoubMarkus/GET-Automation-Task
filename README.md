# GET Group - E-commerce Automation Project  

This project is an automation task assigned by **GET Group**. Below is an explanation of the work done in this project.  

## Project Structure  

1. **Well-structured Selenium Project (Using Maven)**  
   - Created a `BaseTest` class.  
   - Used **TestNG** to manage test execution and reporting.
   - Page Object Model (POM ) implementation  

2. **Data-Driven Testing (Excel Integration)**  
   - Used an **Excel file** to store test data, including:  
     - Username & Password  
     - Product Category  
     - Search Item  
   - Implemented data import from Excel for test execution.  

3. **Enhanced Test Reporting & Debugging**  
   - Implemented **screenshot capture** on test failure.  
   - Integrated **Extent Reports** to log test results and attach screenshots.  
   - Captured screenshots on the last successful order.  

4. **Custom Product Search Implementation**  
   - The website lacks a built-in search function.  
   - Developed a **manual search mechanism** using Selenium:  
     - The category and item are read from the Excel file.  
     - Selenium scans all listed items until it finds the requested one.  

## Technologies Used  
- **Selenium WebDriver (Java)**  
- **TestNG**  
- **Apache POI (Excel Integration)**  
- **Maven**  
- **Extent Reports**  

---

This automation ensures efficient product search and checkout flow, making up for missing search functionality on the website.  
