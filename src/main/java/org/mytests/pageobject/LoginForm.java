package org.mytests.pageobject;

/**
 * Created by Олег on 17.11.2016.
 */

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.junit.Assert;
import org.mytests.entitles.User;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 16.11.2016.
 */
public class LoginForm extends Form<User> {
    @FindBy(css = ".uui-profile-menu")
    public IButton profileButton;
    @FindBy(id = "Login")
    public ITextField login;
    @FindBy(id = "Password")
    public ITextField password;
    @FindBy(css = ".logout")
    public IButton logoutButton;
    @FindBy(css = ".login-txt")
    public TextField errorMessage;
    @FindBy(xpath = "//button[@type='submit']")
    public Button submit;
    @FindBy(css = ".profile-photo span")
    public IButton userName;

    @Override
    public void submit(User user){
        profileButton.click();
        super.submit(user);
    }
    public void checkLogin(boolean stateData) {
        if (stateData) {
            Assert.assertEquals(stateData, logoutButton.isDisplayed());// проверяем появилась ли кнопка "logout"
        } else {
            Assert.assertEquals("* Login Faild", errorMessage.getText());
        }
    }
}
