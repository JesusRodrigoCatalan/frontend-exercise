package jesus.rodrigo.pages;

import jesus.rodrigo.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartPage {
    WebDriver driver;
    WebDriverWait driverWait;
    private static final Logger LOGGER= LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver){
        this.driver= driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driverWait= new WebDriverWait(this.driver, 10);

    }
    public void goToCartPage (){
        LOGGER.info("Navigating to cart page");
        driver.findElement(By.xpath(Constants.CART)).click();
    }
    public void deleteProductFromCart(String product){
        LOGGER.info("Deleting product {} from cart", product);
        driver.findElement(By.xpath("//td[text()='"+product+"']/following-sibling::td[2]/child::a")).click();
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='"+product+"']/following-sibling::td[2]/child::a")));
    }
    public void placeOrder(){
        LOGGER.info("Placing order");
        driver.findElement(By.xpath(Constants.XPATH_PLACE_ORDER)).click();
    }

}
