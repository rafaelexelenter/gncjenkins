package pages;

import dto.User;

public interface RegistrationPage
{
     void registration(User user);
     void submitForm();
     String readMessage();
}
