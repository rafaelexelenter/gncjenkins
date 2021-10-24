package steps;

import dto.BaseResponse;
import dto.User;
import dto.UserRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.junit.Assert;
import pages.NavigationComponent;
import pages.Pages;
import repositories.UserRepository;

import java.util.List;

public class RegistrationSteps implements En
{

    private Pages pages;
    User userDetails;
    private UserRepository userRepository;
    private BaseResponse actualResponse;
    public RegistrationSteps(Pages pages, User userDetails, UserRepository userRepository)
    {
        this.pages = pages;
        this.userDetails = userDetails;
        this.userRepository = userRepository;
    }
    @Given("User sing up with details")
    public void userSingUpWithDetails(List<User> userList)
    {
        this.pages.navigationComponent.navigateToRegistration();
        userDetails = userList.stream().findFirst().orElse(null);
        this.pages.userDetails = userDetails;

    }

    @When("User submits form")
    public void userSubmitsForm()
    {
        this.pages.registrationPage.registration(this.userDetails);
        this.pages.registrationPage.submitForm();
    }

    @Then("User can read a {string} message")
    public void userCanReadAMessage(String expectedMessage)
    {
        Assert.assertEquals("message:",expectedMessage,this.pages.registrationPage.readMessage());
    }

    @When("User process the create profile request")
    public void userProcessTheCreateProfileRequest()
    {
        UserRequest userRequest = new UserRequest(){{
           setUsername(userDetails.getUsername());
           setFirstName(userDetails.getFirstName());
           setLastName(userDetails.getLastName());
           setPassword(userDetails.getPassword());
           setConfirmPassword(userDetails.getConfirmPassword());
        }};

        actualResponse =  userRepository.createUser(userRequest);
    }

    @Then("User Get a {int} response")
    public void userGetAResponse(int expectedStatusResponseCode)
    {
        Assert.assertEquals("Response status:",expectedStatusResponseCode,actualResponse.getStatus());
    }
}
