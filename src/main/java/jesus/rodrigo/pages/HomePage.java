package jesus.rodrigo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    WebDriverWait driverWait;
    private static final Logger LOGGER= LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver){
        this.driver= driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driverWait= new WebDriverWait(this.driver, 10);

    }
    public void selectCategory(String category){
        LOGGER.info("Selecting category {}", category);
        driver.findElement(By.xpath("//a[text()='"+category+"']")).click();
    }
    public void addProductToCart(String product) {
        LOGGER.info("Adding product {} to the cart", product);
        driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
        driverWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        this.goToHomePage();
    }
    public void goToHomePage (){
        LOGGER.info("Navigating to home page");
        driver.findElement(By.xpath("//a[@href='index.html']")).click();
    }

}
