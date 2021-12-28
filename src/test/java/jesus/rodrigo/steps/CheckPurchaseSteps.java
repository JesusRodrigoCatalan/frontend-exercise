package jesus.rodrigo.steps;

import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jesus.rodrigo.constants.Constants;
import jesus.rodrigo.pages.CartPage;
import jesus.rodrigo.pages.HomePage;
import jesus.rodrigo.pages.PlaceOrderForm;
import jesus.rodrigo.pages.PurchaseConfirmation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;


public class CheckPurchaseSteps {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    PlaceOrderForm placeOrderForm;
    PurchaseConfirmation purchaseConfirmation;
    String id;
    String amount;
    private static final Logger LOGGER = LogManager.getLogger(CheckPurchaseSteps.class);


    @Before
    public void initializeDriver(){
        LOGGER.info("Initializing drivers");
        System.setProperty(Constants.DRIVER, Constants.DRIVER_EXE);
        this.driver=new ChromeDriver();
    }

    @After
    public void closeDriver(){
        LOGGER.info("Closing drivers");
        driver.quit();
    }

    @Given("the user opens {string}")
    public void userOpensTheBrowser(String url){
        driver.get(url);
    }

    @When("{string} and {string} from category {string} are added to cart")
    public void productsAreAddedToCart(String item1, String item2, String category) {
        homePage=new HomePage(driver);
        homePage.selectCategory(category);
        homePage.addProductToCart(item1);
        homePage.selectCategory(category);
        homePage.addProductToCart(item2);
    }

    @And("{string} is deleted from cart")
    public void productIsDeletedFromCart(String item) {
        cartPage=new CartPage(driver);
        cartPage.goToCartPage();
        cartPage.deleteProductFromCart(item);
        cartPage.placeOrder();
    }

    @And("I fill web form and purchase with {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillFormAndPurchase(String name, String country, String city, String creditCard, String month, String year) {
        placeOrderForm=new PlaceOrderForm(driver);
        placeOrderForm.fillOrderForm(name, country, city, creditCard, month, year);
        placeOrderForm.purchase();
    }

    @And("I capture purchase Id and Amount")
    public void capturePurchaseIdAndAmount(){
        purchaseConfirmation= new PurchaseConfirmation(driver);
        this.id= purchaseConfirmation.getId(purchaseConfirmation.getPurchaseDetails());
        this.amount=purchaseConfirmation.getAmount(purchaseConfirmation.getPurchaseDetails());
        LOGGER.info("The Id and the amount are "+this.id+" , "+this.amount);
    }

    @Then("I Assert purchase amount equals {string}")
    public void assertPurchaseAmountEqualsExpected(String expectedAmount){
        assertEquals(expectedAmount,amount);
    }
}





