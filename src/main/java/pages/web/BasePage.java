package pages.web;


import controllers.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    public WebDriver driver;
    BasePage(WebDriverController driver)
    {
        this.driver = driver.getDriver();
    }

    public WebElement FindElement(By locator)
    {
        WebDriverWait wait =  new WebDriverWait(driver,10);
        return  wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getAlertMessage(By message)
    {
        int attempts = 0;
        boolean alertIsPresent = false;
        String alertMessage = null;
        while (!alertIsPresent && attempts <=3)
        {
            waitForSeconds();

            List<WebElement> alerts = driver.findElements(message).
                    stream().filter(x-> !x.getText().isEmpty()).
                    collect(Collectors.toList());

            alertIsPresent = !alerts.isEmpty();
            if(alertIsPresent)
            {
                WebElement alert = alerts.stream().findFirst().orElse(null);
                alertMessage = alert.getText();
            }
            attempts++;
        }
        return  alertMessage;
    }

    public void waitForSeconds()
    {
        try
        {
            Thread.sleep(1000);
        }catch (Exception ex){}

    }
}
