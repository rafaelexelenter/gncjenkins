package steps;

import dto.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import pages.Pages;

import java.util.List;

public class ProfileSteps implements En
{
    private User userDetails;
    private Pages pages;
    public ProfileSteps(Pages pages)
    {
        this.pages = pages;
        userDetails = pages.userDetails;
    }
    @And("User Navigates to profile")
    public void userNavigatesToProfile()
    {
       this.pages.navigationComponent.navigateToProfile();
    }

    @When("User updates")
    public void userUpdates(List<User> user)
    {
        this.pages.profilePage.updateProfilePage(user.stream().findFirst().orElse(null));
    }


    @And("User saves updated details")
    public void userSavesUpdatedDetails()
    {
        this.pages.profilePage.saveProfile();
    }
}
