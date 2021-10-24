package steps;

import dto.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.junit.Assert;
import pages.Pages;

import java.util.List;

public class LoginSteps
{
    private User userDetails;
    private Pages pages;
    public LoginSteps(Pages pages )
    {
        this.userDetails = pages.userDetails;
        this.pages = pages;
    }
    @When("User Login to Buggy cars website")
    public void userLoginToBuggyCarsWebsite()
    {
        pages.loginPage.Login(userDetails.getUsername(),userDetails.getPassword());
    }

    @Then("User is able to see his name on the top nav bar")
    public void userIsAbleToSeeHisNameOnTheTopNavBar()
    {
        String expectedProfileName = "Hi, "+userDetails.getFirstName();
        Assert.assertEquals("Profile Name:",expectedProfileName,pages.navigationComponent.readProfileName());
    }

    @When("User Login to Buggy cars website with wrong")
    public void userLoginToBuggyCarsWebsiteWithWrongPassword(List<User> users)
    {
        setNewUserDetails(users.stream().findFirst().orElse(userDetails));
        pages.loginPage.Login(userDetails.getUsername(),userDetails.getPassword());
    }

    @Then("User is presented with error message {string}")
    public void userIsPresentedWithErrorMessage(String expectedMessage)
    {
        Assert.assertEquals("Error Message:",expectedMessage,pages.loginPage.ReadError());
    }

    private void setNewUserDetails(User user)
    {
        if(user.getUsername() != null && !user.getUsername().isEmpty())
        {
            userDetails.setUsername(user.getUsername());
        }
        if(user.getPassword() != null && !user.getPassword().isEmpty())
        {
            userDetails.setPassword(user.getPassword());
        }
    }
}
