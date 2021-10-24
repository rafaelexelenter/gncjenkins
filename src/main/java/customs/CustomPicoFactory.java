package customs;

import controllers.ChromeController;
import controllers.SauceLabController;
import dto.User;
import helpers.ReadConfigHelper;
import pages.RegistrationPage;
import pages.web.WebLoginPage;
import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;
import pages.web.WebNavigationComponent;
import pages.web.WebProfilePage;
import pages.web.WebRegistrationPage;
import repositories.UserRepositoryImpl;


public class CustomPicoFactory implements ObjectFactory
{
    private PicoFactory delegate = new PicoFactory();
    private ReadConfigHelper readConfigHelper = new ReadConfigHelper();
    public CustomPicoFactory()
    {
        setDriver();
        addClass(ReadConfigHelper.class);
        addClass(WebLoginPage.class);
        addClass(WebNavigationComponent.class);
        addClass(WebRegistrationPage.class);
        addClass(UserRepositoryImpl.class);
        addClass(WebProfilePage.class);
        addClass(User.class);
    }


    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }

    private void setDriver()
    {
        boolean readOnLocal = Boolean.parseBoolean(readConfigHelper.readRunOnLocal());
        if(readOnLocal)
        {
            addClass(ChromeController.class);
            return;
        }
        addClass(SauceLabController.class);
    }
}
