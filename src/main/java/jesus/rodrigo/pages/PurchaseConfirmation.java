package jesus.rodrigo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class PurchaseConfirmation {
    WebDriver driver;
    WebDriverWait driverWait;
    private static final Logger LOGGER = LogManager.getLogger(PurchaseConfirmation.class);

    public PurchaseConfirmation(WebDriver driver){
        this.driver= driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driverWait= new WebDriverWait(this.driver, 10);

    }
    public String[] getPurchaseDetails(){
        LOGGER.info("Getting purchase details");
        String details=driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        Pattern pattern = Pattern.compile("\\\n");
        String[] result= pattern.split(details);
        return result;
    }
    public String getId(String[] details){
        return details[0].replace("Id:","").trim();
    }
    public String getAmount(String[] details){
        return details[1].replace("Amount:","").trim();
    }
}
