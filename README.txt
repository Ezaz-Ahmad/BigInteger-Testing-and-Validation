SENG3320 Assignment 1 - README

Project Overview
---------------
This project contains the implementation and testing for Assignment 1 of SENG3320. It includes a custom BigInteger class (BigInteger.java) with helper class MPN.java, and JUnit test classes for black-box testing (BlackboxTesting.java), structural testing (BigIntegerStructuralTest.java), and data flow testing (BigIntegerDataFlowTest.java). The project is built using Maven and IntelliJ IDEA.

Java Version
------------
- Java Version: 23
  The project is developed and tested using Java 23, as specified in the pom.xml file.

IDE Used
--------
- IDE: IntelliJ IDEA 
  The project was developed using IntelliJ IDEA, which provides built-in support for Maven and JUnit testing.

External Libraries and Dependencies
-----------------------------------
- JUnit 5 (junit-jupiter): Version 5.10.0
  This dependency is used for unit testing and is specified in the pom.xml file with scope 'test'. It includes the JUnit 5 API, engine, and parameterized tests support.
  

Instructions for Compiling and Executing the Tests
--------------------------------------------------
1. **Prerequisites:**
   - Java 23 is installed on system.
   -  Maven is installed (or use IntelliJ IDEA’s built-in Maven support).

2. **Open the Project in IntelliJ IDEA:**
   - Launch IntelliJ IDEA.
   - Select "Open" and navigate to the project directory (Assignment01, the folder containing pom.xml).
   - Open the project as a Maven project. IntelliJ will automatically detect the pom.xml file and import the project.

3. **Sync the Maven Project:**
   - Once the project is opened, IntelliJ will prompt you to "Import Changes" for Maven (a popup may appear, or you can click the "Maven" tab on the right).
   - Click "Reload All Maven Projects" (the refresh icon in the Maven tab) to download dependencies (JUnit 5) and sync the project.

4. **Verify the Project Structure:**
   - The project should have the following structure:
     Assignment01/
     ├── src/
     │   ├── main/
     │   │   └── java/
     │   │       └── org/
     │   │           └── example/
     │   │               ├── BigInteger.java
     │   │               └── MPN.java
     │   └── test/
     │       └── java/
     │           └── org/
     │               └── example/
     │                   ├── BlackboxTesting.java
     │                   ├── BigIntegerStructuralTest.java
     │                   └── BigIntegerDataFlowTest.java
     ├── pom.xml
     ├── README.txt
     └── Report.pdf
   
5. **Compile the Project:**
   - IntelliJ IDEA automatically compiles the project when you build or run tests. To manually compile, you can run:
     mvn clean compile
   - In IntelliJ, go to the "Maven" tab, expand "Lifecycle," and double-click "compile."

6. **Execute the Tests:**
   - In IntelliJ IDEA:
     - Open each test class under src/test/java/org/example/:
       - BlackboxTesting.java (Task 1b)
       - BigIntegerStructuralTest.java (Tasks 2, 3b, 3c, 3d)
       - BigIntegerDataFlowTest.java (Tasks 3b, 3c, 3d)
     - Right-click on each test class in the Project Explorer and select "Run '<ClassName>'" (e.g., "Run 'BigIntegerStructuralTest'").
     - Alternatively, click the green "Run" button next to the class name or individual test methods.
     - The test results will be displayed in the "Run" tab (IntelliJ) or terminal . 

7. **Troubleshooting:**
   - If tests fail to run, ensure JUnit 5 is correctly added:
     - Verify the dependency in pom.xml (junit-jupiter, version 5.10.0).
     - Re-sync the Maven project in IntelliJ (click "Reload All Maven Projects").
   - If there are compilation errors, ensure Java 23 is set as the project SDK:
     - Go to File > Project Structure > SDKs, and ensure Java 23 is selected.
   - If the package structure doesn’t match, adjust the package declaration in the Java files or move files to the correct directory (e.g., src/main/java/org/example).