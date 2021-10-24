package pages.web;

import controllers.WebDriverController;
import pages.LoginPage;
import org.openqa.selenium.By;

public class WebLoginPage extends BasePage implements LoginPage {

    private By userName = By.name("login");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By message = By.xpath("//span[contains(@class,'label-warning')]");


    public WebLoginPage(WebDriverController driver) {
        super(driver);
    }

    @Override
    public void Login(String user, String password) {
        FindElement(this.userName).sendKeys(user);
        FindElement(this.password).sendKeys(password);
        FindElement(this.loginButton).click();
        waitForSeconds();
    }

    @Override
    public String ReadError()
    {
        return getAlertMessage(message);
    }
}
