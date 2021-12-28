#Project Title
Exercise 2 - Web FE Automation

#Project Description
Java application implemented to test the following Web:https://www.demoblaze.com/index.html

The task is divided in different tasks, as follow:
-Customer navigation through product categories: Phones, Laptops and Monitors
-Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
-Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
-Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
-Click on "Place order".
-Fill in all web form fields.
-Click on "Purchase"
-Capture and log purchase Id and Amount.
-Assert purchase amount equals expected.
-Click on "Ok"

# How to install and usage
You can download the project from:
XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
Previous to running the test application in your IDE, check that you have installed the following:
-Java JDK 1.8
-Maven
To run the tests, open Terminal tab and go to the project root.
Execute the following command: mvn test
Or directly running from from the class src/test/java/jesus/rodrigo/runners/TestRunner.java
This test is set to be run in Windows, for other OS, changes may be needed. 

#Technologies used:
-Cucumber framework 7.1.0
-Junit 4.11
-Selenium 3.141.59
-Log4j2 2.17.0


#Configuration
The project contains the following packages and resources:

###src/main/java/jesus/rodrigo/constants
Contains Constants.class.
Used for storing constant config parameters.
###src/main/java/jesus/rodrigo/pages
Contains CartPage.class, HomePage.class, PlaceOrderForm.class, PurchaseConfirmation.class
Used for web navigation/taking required actions in their corresponding web pages.

###src/test/java/jesus/rodrigo/runners
Contains TestRunner.class.
Class which triggers the application.
###src/test/java/jesus/rodrigo/steps
Contains CheckApiSteps.class.
Used for implementing steps corresponding to behavioural scenarios, that lead
to API interaction methods.

###src/test/resources/features
Contains check_purchase_amount.feature.
Used for implementing the different scenarios to be accomplished in the test,
in Gherkin sintaxis.


