package pages.web;

import controllers.WebDriverController;
import dto.User;
import org.openqa.selenium.By;
import pages.ProfilePage;
import pages.RegistrationPage;

public class WebProfilePage extends BasePage implements ProfilePage
{
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By saveBtn = By.xpath("//button[contains(text(),'Save')]");
    public WebProfilePage(WebDriverController driver)
    {
        super(driver);
    }

    @Override
    public void updateProfilePage(User user)
    {
        if(user == null)
        {
            throw new RuntimeException("User should not be null:");
        }
        updateUserProfile(user);
    }

    @Override
    public void saveProfile()
    {
        FindElement(saveBtn).click();
    }

    private void updateUserProfile(User user)
    {
        if(user.getFirstName() != null && !user.getFirstName().isEmpty())
        {
            FindElement(firstName).clear();
            FindElement(firstName).sendKeys(user.getFirstName());
        }
        if(user.getLastName() != null && !user.getLastName().isEmpty())
        {
            FindElement(lastName).clear();
            FindElement(lastName).sendKeys(user.getLastName());
        }
    }
}
