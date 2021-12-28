package jesus.rodrigo.pages;

import jesus.rodrigo.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class PlaceOrderForm {
    WebDriver driver;
    WebDriverWait driverWait;
    private static final Logger LOGGER= LogManager.getLogger(CartPage.class);

    public PlaceOrderForm(WebDriver driver){
        this.driver= driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driverWait= new WebDriverWait(this.driver, 10);

    }
    public void fillOrderForm(String name, String country, String city, String creditCard, String month, String year){
        LOGGER.info("Filling form with data: name {},country {}, city {}, credit card {}, month {}, year{}", name, country, city, creditCard, month, year);
        driver.findElement(By.xpath(Constants.XPATH_NAME)).sendKeys(name);
        driver.findElement(By.xpath(Constants.XPATH_COUNTRY)).sendKeys(country);
        driver.findElement(By.xpath(Constants.XPATH_CITY)).sendKeys(city);
        driver.findElement(By.xpath(Constants.XPATH_CARD)).sendKeys(creditCard);
        driver.findElement(By.xpath(Constants.XPATH_MONTH)).sendKeys(month);
        driver.findElement(By.xpath(Constants.XPATH_YEAR)).sendKeys(year);
    }
    public void purchase(){
        LOGGER.info("Purchasing order");
        driver.findElement(By.xpath(Constants.XPATH_PURCHASE_BUTTON)).click();
    }
}
