package org.mytests.pageobject;

/**
 * Created by Олег on 17.11.2016.
 */

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.junit.Assert;
import org.mytests.other.User;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 16.11.2016.
 */
public class LoginForm extends Form<User> {
    @FindBy(css = ".uui-profile-menu")
    public Button profileButton;
    @FindBy (id = "Login")
    public TextField loginField;
    @FindBy(id = "Password")
    public TextField passwordField;
    @FindBy(xpath = "//div[@class='logout']")
    public Button logoutButton;
    @FindBy(css = ".login-txt")
    public TextField errorMessage;
    @FindBy(xpath = "//button[@type='submit']")
    public Button submitButton;

    public void login(User user){
        profileButton.click();
        loginField.setValue(user.getName());
        passwordField.setValue(user.getPassword());
        submitButton.click();
    }
    public void checkLogin(boolean stateData) {
        if (stateData) {
            Assert.assertEquals(stateData, logoutButton.isDisplayed());// проверяем появилась ли кнопка "logout"
        } else {
            Assert.assertEquals("* Login Faild", errorMessage.getText());
        }
    }
}
